package com.example.elsysandroid.activities;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.elsysandroid.R;
import com.example.elsysandroid.devices.Device;
import com.example.elsysandroid.devices.DeviceList;

import java.util.ArrayList;

public class OutputsActivityController {

    private final DeviceList deviceList;
    private final Activity activity;
    private Spinner outputsSpinner;
    private TextView selection;

    public Device selectedDevice;

    public OutputsActivityController(DeviceList devicesList,
                                     Activity activity) {
        this.deviceList = devicesList;
        this.activity = activity;
    }

    private void onClickOutputsSpinner() {
        ArrayList<String> outsList = new ArrayList<>();
        for (Device devices : deviceList.getOuts()) {
            outsList.add(devices.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, outsList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        outputsSpinner.setAdapter(adapter);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getItemAtPosition(position) + ", " + position;
                selection.setText(item);
                selectedDevice = deviceList.getOuts().get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        outputsSpinner.setOnItemSelectedListener(itemSelectedListener);
    }

    public void onActivityCreate() {
        activity.setContentView(R.layout.activity_outputs);
        outputsSpinner = activity.findViewById(R.id.outputs_spinner);
        selection = activity.findViewById(R.id.outputs_text_view);
        onClickOutputsSpinner();
    }
}