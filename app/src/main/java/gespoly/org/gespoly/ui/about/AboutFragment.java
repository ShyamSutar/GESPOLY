package gespoly.org.gespoly.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import gespoly.org.gespoly.Adapter.BranchAdapter;
import gespoly.org.gespoly.Model.BranchModel;
import gespoly.org.gespoly.R;


public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);


        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_computer, "Computer Department", "Department Of Computer Engineering VISION: To contribute to the society through excellence in scientific and knowledge-based education utilising the potential …."));
        list.add(new BranchModel(R.drawable.ic_mechanical, "Mechanical Department", "Department Of Mechanical Engineering VISION: The Mechanical Engineering Department endeavors to be recognized globally for outstanding education and research leading to …."));
        list.add(new BranchModel(R.drawable.ic_electric, "Electrical Department", "Department of Electrical Engineering VISION: To evolve as a centre of excellence,to train students in contemporary technologies,to meet the needs of global industry and to ….."));
        list.add(new BranchModel(R.drawable.ic_civil, "Civil Department", "Department Of Civil Engineering VISION: To be the fountain-head of quality education delivering civil engineers empowered with necessary knowledge,skill and personality who can lead the society towards …."));

        adapter = new BranchAdapter(getContext(),list);
        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);

        Picasso.get().load(R.drawable.gespoly).into(imageView);



        return view;
    }
}