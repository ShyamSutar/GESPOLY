package gespoly.org.gespoly.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import gespoly.org.gespoly.Adapter.GalleryAdapter;
import gespoly.org.gespoly.R;


public class GalleryFragment extends Fragment {

    RecyclerView computerDepartmentRv, mechanicalDepartmentRv, electricalDepartmentRv, civilDepartmentRv;
    GalleryAdapter adapter;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);


        computerDepartmentRv = view.findViewById(R.id.computerDepartmentRv);
        mechanicalDepartmentRv = view.findViewById(R.id.mechanicalDepartmentRv);
        electricalDepartmentRv = view.findViewById(R.id.electricalDepartmentRv);
        civilDepartmentRv = view.findViewById(R.id.civilDepartmentRv);

        reference = FirebaseDatabase.getInstance().getReference().child("gallery");


        getComputerDepartmentImage();
        getMechanicalDepartmentImage();
        getElectricalDepartmentImage();
        getCivilDepartmentImage();



        return view;
    }

    private void getMechanicalDepartmentImage() {
        reference.child("Mechanical Department").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                mechanicalDepartmentRv.setLayoutManager(new GridLayoutManager(getContext(), 3));
                mechanicalDepartmentRv.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getElectricalDepartmentImage() {
        reference.child("Electrical Department").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                electricalDepartmentRv.setLayoutManager(new GridLayoutManager(getContext(), 3));
                electricalDepartmentRv.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getCivilDepartmentImage() {
        reference.child("Civil Department").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                civilDepartmentRv.setLayoutManager(new GridLayoutManager(getContext(), 3));
                civilDepartmentRv.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getComputerDepartmentImage() {

        reference.child("Computer Department").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                computerDepartmentRv.setLayoutManager(new GridLayoutManager(getContext(), 3));
                computerDepartmentRv.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();

            }
        });

    }
}