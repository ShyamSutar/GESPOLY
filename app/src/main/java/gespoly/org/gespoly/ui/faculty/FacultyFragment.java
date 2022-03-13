package gespoly.org.gespoly.ui.faculty;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import gespoly.org.gespoly.Adapter.TeacherAdapter;
import gespoly.org.gespoly.Model.TeacherDataModel;


import gespoly.org.gespoly.R;
import gespoly.org.gespoly.databinding.FragmentFacultyBinding;


public class FacultyFragment extends Fragment {

    FragmentFacultyBinding binding;
    private List<TeacherDataModel> list1, list2, list3, list4;
    private DatabaseReference reference, db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFacultyBinding.inflate(inflater,container,false);



        reference = FirebaseDatabase.getInstance().getReference().child("teachers");

        //creating diff method for ease
        csDapartment();
        meDapartment();
        elDapartment();
        ceDapartment();

        return binding.getRoot();
    }

    private void csDapartment() {
        db = reference.child("Computer Department");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if (!snapshot.exists()){
                    binding.csNoData.setVisibility(View.VISIBLE);
                    binding.csDepartment.setVisibility(View.GONE);
                    Toast.makeText(getContext(), "No image", Toast.LENGTH_SHORT).show();
                }else{

                    binding.csNoData.setVisibility(View.GONE);
                    binding.csDepartment.setVisibility(View.VISIBLE);



                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherDataModel data = dataSnapshot.getValue(TeacherDataModel.class);
//                        data.setKey(dataSnapshot.getKey());
                        list1.add(data);
                    }

                    binding.csDepartment.setHasFixedSize(true);
                    binding.csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    TeacherAdapter adapter = new TeacherAdapter(list1,getContext());
                    binding.csDepartment.setAdapter(adapter);
//                  adapter.notifyDataSetChanged();


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void meDapartment() {
        db = reference.child("Mechanical Department");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();

                if (!snapshot.exists()){
                    binding.meNoData.setVisibility(View.VISIBLE);
                    binding.meDepartment.setVisibility(View.GONE);
                }else {

                    binding.meNoData.setVisibility(View.GONE);
                    binding.meDepartment.setVisibility(View.VISIBLE);

                    binding.meDepartment.setHasFixedSize(true);
                    binding.meDepartment.setLayoutManager(new LinearLayoutManager(getContext()));

                    TeacherAdapter adapter = new TeacherAdapter(list2, getContext());
                    binding.meDepartment.setAdapter(adapter);

                    for (DataSnapshot snap : snapshot.getChildren()) {
                        TeacherDataModel data = snap.getValue(TeacherDataModel.class);
                        list2.add(data);
                    }

                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void elDapartment() {
        db = reference.child("Electrical Department");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if (!snapshot.exists()){
                    binding.elNoData.setVisibility(View.VISIBLE);
                    binding.elDepartment.setVisibility(View.GONE);
                }else{

                    binding.elNoData.setVisibility(View.GONE);
                    binding.elDepartment.setVisibility(View.VISIBLE);

                    binding.elDepartment.setHasFixedSize(true);
                    binding.elDepartment.setLayoutManager(new LinearLayoutManager(getContext()));


                    TeacherAdapter dapter = new TeacherAdapter(list3, getContext());
                    binding.elDepartment.setAdapter(dapter);

                    for (DataSnapshot snap: snapshot.getChildren()){
                        TeacherDataModel data = snap.getValue(TeacherDataModel.class);
                        list3.add(data);
                    }

                    dapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void ceDapartment() {
        db = reference.child("Civil Department");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()){
                    binding.ceNoData.setVisibility(View.VISIBLE);
                    binding.ceDepartment.setVisibility(View.GONE);
                }else{

                    binding.ceNoData.setVisibility(View.GONE);
                    binding.ceDepartment.setVisibility(View.VISIBLE);

                    binding.ceDepartment.setHasFixedSize(true);
                    binding.ceDepartment.setLayoutManager(new LinearLayoutManager(getContext()));

                    TeacherAdapter adapter = new TeacherAdapter(list4, getContext());
                    binding.ceDepartment.setAdapter(adapter);

                    for (DataSnapshot snap: snapshot.getChildren()){
                        TeacherDataModel data = snap.getValue(TeacherDataModel.class);
                        list4.add(data);
                    }

                    adapter.notifyDataSetChanged();



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });



    }

}