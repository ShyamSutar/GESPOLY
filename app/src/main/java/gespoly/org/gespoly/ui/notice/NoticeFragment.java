package gespoly.org.gespoly.ui.notice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

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

import gespoly.org.gespoly.Adapter.NoticeAdapter;
import gespoly.org.gespoly.Model.NoticeModel;
import gespoly.org.gespoly.R;
import gespoly.org.gespoly.databinding.FragmentNoticeBinding;

public class NoticeFragment extends Fragment {
    FragmentNoticeBinding binding;
    private ArrayList<NoticeModel> list;
    private NoticeAdapter adapter;

    private DatabaseReference reference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNoticeBinding.inflate(inflater,container,false);


        reference = FirebaseDatabase.getInstance().getReference().child("Notice");

        binding.deleteNoticeRV.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.deleteNoticeRV.setHasFixedSize(true);

        getNotice();

        return binding.getRoot();

    }

    private void getNotice() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot1 : snapshot.getChildren()){
                    NoticeModel data = snapshot1.getValue(NoticeModel.class);
                    list.add(data);
                }

                adapter = new NoticeAdapter(getContext(), list);
                adapter.notifyDataSetChanged();
                binding.progressBar.setVisibility(View.GONE);
                binding.deleteNoticeRV.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                binding.progressBar.setVisibility(View.GONE);

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    }
