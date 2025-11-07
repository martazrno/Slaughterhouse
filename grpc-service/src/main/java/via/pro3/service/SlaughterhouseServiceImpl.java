package via.pro3.service;

import io.grpc.stub.StreamObserver;
import via.pro3.slaughterhouse.generated.*;
import via.pro3.repository.AnimalProductRepo;

// the class needs to extend the base, which has method names, but no behaviour
public class SlaughterhouseServiceImpl extends SlaughterhouseServiceGrpc.SlaughterhouseServiceImplBase {

    private final AnimalProductRepo repo = new AnimalProductRepo();

    @Override
    public void getAnimalsForProduct(ProductRequest request, StreamObserver<AnimalList> responseObserver) {
        var animalIds = repo.getAnimalsForProduct(request.getProductId());
        AnimalList.Builder list = AnimalList.newBuilder();
        for (String id : animalIds) {
            list.addAnimals(Animal.newBuilder()
                    .setAnimalId(id)
                    .setRegistrationNumber(repo.getRegistrationNumber(id))
                    .build());}
        responseObserver.onNext(list.build());
        responseObserver.onCompleted();}

    @Override
    public void getProductsForAnimal(AnimalRequest request, StreamObserver<ProductList> responseObserver) {
        var productIds = repo.getProductsForAnimal(request.getAnimalId());
        ProductList.Builder list = ProductList.newBuilder();
        for (String id : productIds) {
            list.addProducts(Product.newBuilder()
                    .setProductId(id)
                    .setProductName(repo.getProductName(id))
                    .build());}
        responseObserver.onNext(list.build());
        responseObserver.onCompleted();}

}
