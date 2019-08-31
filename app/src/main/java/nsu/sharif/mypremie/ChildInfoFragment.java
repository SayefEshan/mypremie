package nsu.sharif.mypremie;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class ChildInfoFragment extends Fragment {

    Button firstButton = null;
    RelativeLayout myLayout = null;
    //private Button activateAddchildActivity;

    public ChildInfoFragment() {

    }


    @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_child_info, container, false);

        Button addBabyButton = (Button) view.findViewById(R.id.addBabyButton);
        addBabyButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),babyRegistration.class);
                startActivity(intent);
            }
        });

        return view;


    }

}
