package projectite.m2.fe.rupp.edu.iteonlineshop.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import projectite.m2.fe.rupp.edu.iteonlineshop.R;
import projectite.m2.fe.rupp.edu.iteonlineshop.databinding.ActivityMainBinding;
import projectite.m2.fe.rupp.edu.iteonlineshop.ui.fragment.HomeFragment;
import projectite.m2.fe.rupp.edu.iteonlineshop.ui.fragment.MoreFragment;
import projectite.m2.fe.rupp.edu.iteonlineshop.ui.fragment.ProductFragment;
import projectite.m2.fe.rupp.edu.iteonlineshop.ui.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // ShowHomeFragment
        showFragment(new HomeFragment());
        binding.bottomNav.setBackground(null);

        // Set Listeners
        binding.bottomNav.setOnItemSelectedListener( item -> {

            if (item.getItemId() == R.id.home){
                HomeFragment homeFragment = new HomeFragment();
                showFragment(new HomeFragment());
                // Example2 (- showFragment(new HomeFragment()); -)
            } else if (item.getItemId() == R.id.product){
                ProductFragment productFragment =  new ProductFragment();
                showFragment(new ProductFragment());
            } else if (item.getItemId() == R.id.profile){
                ProfileFragment profileFragment = new ProfileFragment();
                showFragment(new ProfileFragment());
            } else if (item.getItemId() == R.id.more){
                MoreFragment moreFragment = new MoreFragment();
                showFragment(new MoreFragment());
            }

            return false;
        });
    }

    private void showFragment(Fragment fragment) {

        // Need FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Need FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace Fragment in lytFragment
        fragmentTransaction.replace(R.id.frameName, fragment);

        // Commit Transaction
        fragmentTransaction.commit();
    }
}