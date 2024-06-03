package com.example.fragment_image_spi_toptnwjd;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    private ImageView imageView;
    private Spinner spinner;
    private Switch switchToggle;
    private CheckBox checkBox;
    private EditText editText;
    private Button buttonShowInput;
    private SeekBar seekBar;
    private TextView seekBarValue;
    private TextView textViewInput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        imageView = view.findViewById(R.id.imageView);
        spinner = view.findViewById(R.id.spinner);
        switchToggle = view.findViewById(R.id.switchToggle);
        checkBox = view.findViewById(R.id.checkBox);
        editText = view.findViewById(R.id.editText);
        buttonShowInput = view.findViewById(R.id.buttonShowInput);
        seekBar = view.findViewById(R.id.seekBar);
        seekBarValue = view.findViewById(R.id.seekBarValue);
        textViewInput = view.findViewById(R.id.textViewInput);

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

        // 스위치 토글 시 배경색 변경
        switchToggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                view.setBackgroundColor(Color.GREEN);
            } else {
                view.setBackgroundColor(Color.WHITE);
            }
        });

        // 체크박스 체크 시 토스트 메시지 표시
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(getActivity(), "그림 확인", Toast.LENGTH_SHORT).show();
            }
        });

        // 버튼 클릭 시 EditText 입력 내용 표시
        buttonShowInput.setOnClickListener(v -> {
            String inputText = editText.getText().toString();
            textViewInput.setText(inputText);
        });

        // SeekBar 값 변경
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarValue.setText("Value: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }
        });

        return view;
    }
}
