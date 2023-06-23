package com.example.loadingpage;
import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.loadingpage.R;
import com.example.loadingpage.addrecord1;

public class scanreceipt5 extends AppCompatActivity {
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 123;
    private static final int IMAGE_CAPTURE_REQUEST_CODE = 456;
    private static final int CAMERA_REQ_CODE = 100;
    private Uri imageUri;
    ImageView imgCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanreceipt5);

        imgCamera = findViewById(R.id.imgCam);
        Button captureButton = findViewById(R.id.captureButton);
        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(scanreceipt5.this, Manifest.permission.CAMERA)
                        == PackageManager.PERMISSION_GRANTED) {
                    captureImage();
                } else {
                    ActivityCompat.requestPermissions(scanreceipt5.this,
                            new String[]{Manifest.permission.CAMERA},
                            CAMERA_PERMISSION_REQUEST_CODE);
                }
//                Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(iCamera, CAMERA_REQ_CODE);

            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode == RESULT_OK){
//            if (requestCode == CAMERA_REQ_CODE){
//                Bitmap img = (Bitmap) data.getExtras().get("data");
//                imgCamera.setImageBitmap(img);
//            }
//        }
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                captureImage();
            } else {
                Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }



    private void captureImage() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "Receipt");
        values.put(MediaStore.Images.Media.DESCRIPTION, "Receipt Image");
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");

        imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

        if (captureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(captureIntent, IMAGE_CAPTURE_REQUEST_CODE);
        } else {
            Toast.makeText(this, "No camera app found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMAGE_CAPTURE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                saveImageToAlbum();
            } else {
                Toast.makeText(this, "Image capture failed. Please try again.", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void saveImageToAlbum() {
        // Display a preview of the captured image (optional)
        ImageView imageView = findViewById(R.id.imgCam);
        imageView.setImageURI(imageUri);

        // Save the image to the album using MediaStore
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        mediaScanIntent.setData(imageUri);
        sendBroadcast(mediaScanIntent);

        // Navigate back to the addrecord1 activity or perform any other required action
        Intent intent = new Intent(scanreceipt5.this, addrecord1.class);
        startActivity(intent);
    }
}
