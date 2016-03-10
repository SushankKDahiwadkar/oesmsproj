package com.sushank.loginregistermaterial.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sushank.loginregistermaterial.R;
import com.sushank.loginregistermaterial.adapter.AppController;
import com.sushank.loginregistermaterial.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.sushank.loginregistermaterial.util.GlobalConstant.HOST_SERVER;

/**
 * Created by sushank_dahiwadkar on 12/16/2015.
 */
public class ProfileFragment extends Fragment{

    private EditText inputFirstName, inputEmail, inputPassword, inputLastName, inputUserName;
    private TextInputLayout inputLayoutFirstName, inputLayoutEmail, inputLayoutPassword, inputLayoutLastName, inputLayoutUserName;
    private Button btnSignUp;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        // Inflate the layout for this fragment
        btnSignUp = (Button) rootView.findViewById(R.id.btn_signup);
        inputLayoutFirstName = (TextInputLayout) rootView.findViewById(R.id.input_layout_firstname);
        inputLayoutLastName = (TextInputLayout) rootView.findViewById(R.id.input_layout_lastname);
        inputLayoutUserName = (TextInputLayout) rootView.findViewById(R.id.input_layout_username);
        inputLayoutEmail = (TextInputLayout) rootView.findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) rootView.findViewById(R.id.input_layout_password);
        inputFirstName = (EditText) rootView.findViewById(R.id.input_firstname);
        inputLastName = (EditText) rootView.findViewById(R.id.input_lastname);
        inputUserName = (EditText) rootView.findViewById(R.id.input_username);
        inputEmail = (EditText) rootView.findViewById(R.id.input_email);
        inputPassword = (EditText) rootView.findViewById(R.id.input_password);

        inputFirstName.addTextChangedListener(new MyTextWatcher(inputFirstName));
        inputLastName.addTextChangedListener(new MyTextWatcher(inputLastName));
        inputUserName.addTextChangedListener(new MyTextWatcher(inputUserName));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });

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

    private void submitForm() {
        User user = new User();
        if (!validateFirstName()) {
            return;
        }

        if (!validateLastName()) {
            return;
        }

        if (!validateUserName()) {
            return;
        }

        if (!validateEmail()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }

        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Registering...");
        progressDialog.show();


        user.setFirstName(inputFirstName.getText().toString());
        user.setLastName(inputLastName.getText().toString());
        user.setUserName(inputUserName.getText().toString());
        user.setEmail(inputEmail.getText().toString());
        user.setPassword(inputPassword.getText().toString());

        final Gson gson = new Gson();
        String stringUser = gson.toJson(user);
        final String URL = HOST_SERVER + "/User";
        JsonObjectRequest jsonObjectRequest;
        try {
            JSONObject jsonObject = new JSONObject(stringUser);
            Log.i("created Request", jsonObject.toString());
            jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            progressDialog.hide();
                            Log.i("Response", response.toString());
                            User createdUser = gson.fromJson(response.toString(), User.class);
                            if(createdUser.getUserId() != 0){
                                Toast.makeText(getActivity().getApplicationContext(), "Registered Successfully.", Toast.LENGTH_SHORT).show();
                                try {
                                    FileOutputStream fileOutputStream = getActivity().openFileOutput("myData", Context.MODE_PRIVATE);
                                    fileOutputStream.write(String.valueOf(createdUser.getUserId()).getBytes());
                                    fileOutputStream.close();
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                navigateHome();
                            } else {
                                Toast.makeText(getActivity().getApplicationContext(), "Error Registering User.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.hide();
                    VolleyLog.d("Error", "Error: " + error.getMessage());
                }
            });


            Log.i("generated request : ", jsonObjectRequest.toString());
            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                    10000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            AppController.getInstance().addToRequestQueue(jsonObjectRequest, "Get Test Details");


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void navigateHome(){
        Fragment fragment = new HomeFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_body, fragment);
        fragmentTransaction.commit();
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().isEmpty()) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }


    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateFirstName() {
        if (inputFirstName.getText().toString().trim().isEmpty()) {
            inputFirstName.setError("Enter First Name");
            requestFocus(inputFirstName);
            return false;
        } else {
            inputLayoutFirstName.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateLastName() {

        if (inputLastName.getText().toString().trim().isEmpty()) {
            inputLastName.setError("Enter Last Name");
            requestFocus(inputLastName);
            return false;
        } else {
            inputLayoutLastName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateUserName() {
        if (inputUserName.getText().toString().trim().isEmpty()) {
            inputUserName.setError("Enter User Name");
            requestFocus(inputUserName);
            return false;
        } else {
            inputLayoutUserName.setErrorEnabled(false);
        }
        return true;
    }


    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }


        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_firstname:
                    validateFirstName();
                    break;
                case R.id.input_lastname:
                    validateLastName();
                    break;
                case R.id.input_username:
                    validateUserName();
                    break;
                case R.id.input_email:
                    validateEmail();
                    break;
                case R.id.input_password:
                    validatePassword();
                    break;
            }
        }
    }
}
