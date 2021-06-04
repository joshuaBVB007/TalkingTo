package com.example.firebase_chat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FirebaseActivity extends AppCompatActivity {
    //variables a utilizar para el sharedpreferences
    String user;
    String contra;


    EditText usernameFire;
    EditText contraseñaFire;
    public static FirebaseAuth firebaseInstance;
    static FirebaseUser usuario_en_activo_de_firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        firebaseInstance=FirebaseAuth.getInstance();
        usernameFire=findViewById(R.id.usernameFirebase);
        contraseñaFire=findViewById(R.id.passwordFirebase);
        usuario_en_activo_de_firebase=firebaseInstance.getCurrentUser();


        SharedPreferences mispreferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
        usernameFire.setText(mispreferencias.getString("user","Example@TalkingTo.com"));
        SharedPreferences mispreferencias2=getSharedPreferences("datos2", Context.MODE_PRIVATE);
        contraseñaFire.setText(mispreferencias2.getString("contra","example"));


    }


    public void registrar_usuario_en_firebase(View view){
        user=usernameFire.getText().toString();
        contra=contraseñaFire.getText().toString();
        SharedPreferences mis=getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=mis.edit();
        editor.putString("user",usernameFire.getText().toString());
        SharedPreferences mis2=getSharedPreferences("datos2", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2=mis2.edit();
        editor2.putString("contra",contraseñaFire.getText().toString());
        editor2.commit();
        editor.commit();
        if (!user.isEmpty() && !contra.isEmpty()){
            firebaseInstance.getInstance()
                    .createUserWithEmailAndPassword(user,contra)
                    .addOnCompleteListener(FirebaseActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(FirebaseActivity.this, "Registro exitoso",
                                        Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(FirebaseActivity.this, "Registro incorrecto.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }else{
            if (user.isEmpty()){
                usernameFire.setError("Campo obligatorio");
            }else if(contra.isEmpty()){
                contraseñaFire.setError("Campo obligatorio");
            }
        }
    }//FIN DEL METODO DE REGISTRO


    public void Iniciar_sesion_en_la_app(View view){
        user=usernameFire.getText().toString();
        contra=contraseñaFire.getText().toString();
        SharedPreferences mis=getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=mis.edit();
        editor.putString("user",usernameFire.getText().toString());
        editor.commit();
        SharedPreferences mis2=getSharedPreferences("datos2", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2=mis2.edit();
        editor2.putString("contra",contraseñaFire.getText().toString());
        editor2.commit();
        if (!user.isEmpty() && !contra.isEmpty()){
            FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(user,contra)
                    .addOnCompleteListener(FirebaseActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(FirebaseActivity.this, "Bienvenido",
                                        Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(FirebaseActivity.this, Menu.class));
                            }else{
                                Toast.makeText(FirebaseActivity.this, "Usuario no registrado",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }else{
            if (user.isEmpty()){
                usernameFire.setError("Campo obligatorio");
            }else if(contra.isEmpty()){
                contraseñaFire.setError("Campo obligatorio");
            }
        }
    }

}