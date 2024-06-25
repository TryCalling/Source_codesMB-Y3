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
import projectite.m2.fe.rupp.edu.iteonlineshop.databinding.FragmentHomeBinding;
import projectite.m2.fe.rupp.edu.iteonlineshop.ui.adapter.ProductAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
}
