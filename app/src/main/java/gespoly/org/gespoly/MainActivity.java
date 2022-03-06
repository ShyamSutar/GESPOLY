package gespoly.org.gespoly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import gespoly.org.gespoly.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ActivityMainBinding binding;
    private NavController navController;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        navController = Navigation.findNavController(this, R.id.frame_layout);
        toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, R.string.start,R.string.close);

        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        binding.navigationView.setNavigationItemSelectedListener(this);


        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.navigation_developer:
                Toast.makeText(this, "Developer", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_video:
                Toast.makeText(this, "Video", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_rate:
                Toast.makeText(this, "Rate", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_ebook:
                Toast.makeText(this, "EBook", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_theme:
                Toast.makeText(this, "Theme", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_website:
                Toast.makeText(this, "website", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
        }


        return true;
    }
}