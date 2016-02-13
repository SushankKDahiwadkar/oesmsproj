package com.sushank.loginregistermaterial.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.sushank.loginregistermaterial.R;
import com.sushank.loginregistermaterial.adapter.AppController;

import org.json.JSONObject;

import static com.sushank.loginregistermaterial.util.GlobalConstant.HOST_SERVER;
import java.text.BreakIterator;

/**
 * Created by sushank_dahiwadkar on 12/16/2015.
 */
public class HomeFragment extends Fragment {
    EditText editText;
    Button btnGo;
    public final static String TEST_ID = "0";
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        editText = (EditText) rootView.findViewById(R.id.editTextTestId);
        btnGo = (Button) rootView.findViewById(R.id.btnGoTest);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTestId();
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void sendTestId(){
        String testId = String.valueOf(editText.getText());
        String url = HOST_SERVER + "/Test/" + testId;
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Fetching Test Details...");
        progressDialog.show();

        JSONObject param = null;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url,param ,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("response", response.toString());

                        Intent intent = new Intent(getActivity().getApplicationContext(), TestDetails.class);
                        intent.putExtra("TEST_DETAILS", response.toString());
                        progressDialog.hide();
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error", "Error: " + error.getMessage());
                // hide the progress dialog
                progressDialog.hide();
            }
        });

        Log.i("generated request : ", jsonObjReq.toString());
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppController.getInstance().addToRequestQueue(jsonObjReq, "Get Test Details");
    }
}
