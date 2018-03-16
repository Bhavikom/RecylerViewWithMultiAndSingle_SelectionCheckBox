package com.constraint.recylerviewwithmultiselectioncheckbox;

/**
 * Created by S Soft on 04-Aug-17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private List<Employee> empList;
    private int selectedPosition = -1;


    public EmployeeAdapter(List<Employee> employees) {
        this.empList = employees;
    }

    @Override
    public EmployeeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_row, null);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        final int pos = position;
        Employee employee = empList.get(position);
        viewHolder.tvName.setText(employee.getEmpName());
        viewHolder.tvComp.setText(employee.getEmpComp());
        viewHolder.tvNum.setText(employee.getNumber());

        /* for multiple selection*/
        viewHolder.chkSelected.setChecked(employee.isSelected());
        viewHolder.chkSelected.setTag(empList.get(position));

        /* for single selection */
        /*viewHolder.chkSelected.setTag(position);
        if (position == selectedPosition) {
            viewHolder.chkSelected.setChecked(true);
        } else {
            viewHolder.chkSelected.setChecked(false);
        }*/
        /* for single selection */

        viewHolder.chkSelected.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /* single selection for checkbox*/
                /*CheckBox cb = (CheckBox) v;
                if(cb.isChecked()){
                    selectedPosition = (int) cb.getTag();
                }else {
                    selectedPosition = -1;
                }
                notifyDataSetChanged();*/
                /* single selection for checkbox*/

               /* for multiple selection of checkbox */
                CheckBox cb = (CheckBox) v;
                Employee emp = (Employee) cb.getTag();

                emp.setSelected(cb.isChecked());
                empList.get(pos).setSelected(cb.isChecked());

                Toast.makeText(
                        v.getContext(),
                        "Selected Employees: " + cb.getText() + " is "
                                + cb.isChecked(), Toast.LENGTH_LONG).show();
                /* end for multiple selection of checkbox */
            }
        });
    }

    @Override
    public int getItemCount() {
        return empList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvComp;
        public TextView tvNum;
        public CheckBox chkSelected;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            tvName = (TextView) itemLayoutView.findViewById(R.id.empName);
            tvComp = (TextView) itemLayoutView.findViewById(R.id.empcomp);
            tvNum = (TextView) itemLayoutView.findViewById(R.id.empNum);
            chkSelected = (CheckBox) itemLayoutView.findViewById(R.id.checkBox);
        }
    }
    public List<Employee> getEmployeeList() {
        return empList;
    }
}