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

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import projectite.m2.fe.rupp.edu.iteonlineshop.api.model.Profile;
import projectite.m2.fe.rupp.edu.iteonlineshop.api.service.ApiService;
import projectite.m2.fe.rupp.edu.iteonlineshop.databinding.FragmentProfileBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);

        // Load list profile from service (api)
        loadProfileFromServer();
        return binding.getRoot();
    }
    private void loadProfileFromServer(){

        // Create retrofit client
        GsonBuilder GsonConverterFactory = null;
        Retrofit httpClient = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .build();

        // Create server object
        ApiService apiService = httpClient.create(ApiService.class);

        // Load profile list from server (api)
        Call<Profile> task = apiService.loadProfileList();
        task.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {

                Log.d("response", String.valueOf(response.body()));

                Profile profile = response.body();
                binding.firstName.setText(profile.getFirstName());
                binding.lastName.setText(profile.getLastName());
                binding.emailName.setText(profile.getEmail());
                binding.txtEmail.setText(profile.getEmail());
                binding.txtPhoneNumber.setText( profile.getPhoneNumber());
                binding.txtGender.setText(profile.getGender());
                binding.txtBirth.setText(profile.getBirthDay());
                binding.txtAddress.setText(profile.getAddress());
                Picasso.get().load(profile.getImageUrl()).into(binding.imgUser);
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                Toast.makeText(binding.getRoot().getContext(), "Loading... ", Toast.LENGTH_LONG).show();
                Log.e("[ProfileFragment]", "Loading... " + t.getMessage());
            }
        });

    }



}
