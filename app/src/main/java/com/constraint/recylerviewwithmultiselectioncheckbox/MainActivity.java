package com.constraint.recylerviewwithmultiselectioncheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView reclist;
    private RecyclerView.Adapter mAdapter;
    private List<Employee> employeeList;
    private Button empBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        empBTN = (Button) findViewById(R.id.btnShow);

        employeeList = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            Employee st = new Employee("EmpName - "+i,"EmpComp - "+i,"EmpNum - "+i,false);

            employeeList.add(st);
        }
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Employee");
        }
        reclist = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        reclist.setHasFixedSize(true);

        // use a linear layout manager
        reclist.setLayoutManager(new LinearLayoutManager(this));

        // create an Object for Adapter
        mAdapter = new EmployeeAdapter(employeeList);

        // set the adapter object to the Recyclerview
        reclist.setAdapter(mAdapter);
        empBTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String secemp = "";
                List<Employee> stList = ((EmployeeAdapter) mAdapter).getEmployeeList();

                for (int i = 0; i < stList.size(); i++) {
                    Employee employee = stList.get(i);
                    if (employee.isSelected() == true) {

                        secemp = secemp + "\n" + employee.getEmpName().toString();

                    }

                }

                Toast.makeText(MainActivity.this,
                        "Selected Employees: \n" + secemp, Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}