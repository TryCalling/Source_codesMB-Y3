package projectite.m2.fe.rupp.edu.iteonlineshop.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import projectite.m2.fe.rupp.edu.iteonlineshop.api.model.Product;
import projectite.m2.fe.rupp.edu.iteonlineshop.api.service.ApiService;
import projectite.m2.fe.rupp.edu.iteonlineshop.databinding.FragmentProductBinding;
import projectite.m2.fe.rupp.edu.iteonlineshop.ui.adapter.ProductAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductFragment extends Fragment {
    private FragmentProductBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProductBinding.inflate(inflater, container, false);
        // Load List courses from server (api)
        loadProductFromServer();
        return binding.getRoot();
    }

    private void loadProductFromServer() {

        // Create retrofit client
        Retrofit httpClient = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create server object
        ApiService apiService = httpClient.create(ApiService.class);


        // Load course list from server (api)
        Call<List<Product>> task = apiService.loadProductList();
        task.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

//                if (response.isSuccessful()) {
                Log.d("response", String.valueOf(response.body()));
                    showProductList(response.body());
//                } else {
//                    Toast.makeText(binding.getRoot().getContext(), "Load Course List failed!", Toast.LENGTH_LONG).show();
//                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(binding.getRoot().getContext(), "Loading...", Toast.LENGTH_LONG).show();
                Log.e("[ProductFragment]", "Loading... " + t.getMessage());

            }
        });
    }
        // run in real device i coming 2 min
        private void showProductList(List<Product> productList) {

            //
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            binding.recyclerViewProduct.setLayoutManager(layoutManager);

            // Create adapter
            ProductAdapter adapter = new ProductAdapter();
            adapter.submitList(productList);
            binding.recyclerViewProduct.setAdapter(adapter);
    }
}
