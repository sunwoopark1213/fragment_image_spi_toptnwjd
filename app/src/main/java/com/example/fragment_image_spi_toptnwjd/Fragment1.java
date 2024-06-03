package com.example.fragment_image_spi_toptnwjd;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    private ImageView imageView;
    private Spinner spinner;
    private Button buttonToast;
    private Button buttonChangeImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        imageView = view.findViewById(R.id.imageView);
        spinner = view.findViewById(R.id.spinner);
        buttonToast = view.findViewById(R.id.buttonToast);
        buttonChangeImage = view.findViewById(R.id.buttonChangeImage);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.options_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = parent.getItemAtPosition(position).toString();
                if (selectedOption.equals("Option 1")) {
                    Intent intent = new Intent(getActivity(), SecondActivity.class);
                    startActivity(intent);
                } else if (selectedOption.equals("Option 2")) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        // 버튼 클릭 시 토스트 메시지 표시
        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Toast Message from Fragment 1", Toast.LENGTH_SHORT).show();
            }
        });

        // 버튼 클릭 시 이미지 변경
        buttonChangeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.new_image); // new_image는 변경될 이미지 리소스
            }
        });

        return view;
    }
}
