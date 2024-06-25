package projectite.m2.fe.rupp.edu.iteonlineshop.api.service;

import java.util.List;

import projectite.m2.fe.rupp.edu.iteonlineshop.api.model.Product;
import projectite.m2.fe.rupp.edu.iteonlineshop.api.model.Profile;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/kimsongsao/ferupp/main/products.json")
    Call<List<Product>> loadProductList();

    @GET("/kimsongsao/ferupp/main/profile.json")
    Call<Profile> loadProfileList();
}
