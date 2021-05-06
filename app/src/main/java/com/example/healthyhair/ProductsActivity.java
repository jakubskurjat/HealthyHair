package com.example.healthyhair;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ProductsActivity extends AppCompatActivity {

    private Button btnAddProduct;
    private ListView listView;
    private EditText etProductName;
    private EditText etProductComposition;
    private RadioGroup rgProductSpec;
    private RadioGroup rgProductType;
    private RadioGroup rgShampooType;
    private RadioGroup rgPorosity;
    private RadioButton rbShampoo;
    private RadioButton rbConditioner;
    private RadioButton rbHairMask;
    private RadioButton rbProtein;
    private RadioButton rbEmollient;
    private RadioButton rbHumectant;
    private RadioButton rbMild;
    private RadioButton rbStrong;
    private RadioButton rbLowPorosity;
    private RadioButton rbMediumPorosity;
    private RadioButton rbHighPorosity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        btnAddProduct = findViewById(R.id.btnAddProduct);
        listView = findViewById(R.id.listOfProducts);
        etProductName = findViewById(R.id.etProductName);
        etProductComposition = findViewById(R.id.etProductComposition);
        rgProductSpec = findViewById(R.id.rgProductSpec);
        rgProductType = findViewById(R.id.rgProductType);
        rgShampooType = findViewById(R.id.rgShampooType);
        rgPorosity = findViewById(R.id.rgPorosity);

        rbShampoo = findViewById(R.id.rbShampoo);
        rbConditioner = findViewById(R.id.rbConditioner);
        rbHairMask = findViewById(R.id.rbHairMask);
        rbProtein = findViewById(R.id.rbProtein);
        rbEmollient = findViewById(R.id.rbEmollient);
        rbHumectant = findViewById(R.id.rbHumectant);
        rbMild = findViewById(R.id.rbMild);
        rbStrong = findViewById(R.id.rbStrong);
        rbLowPorosity = findViewById(R.id.rbLowPorosity);
        rbMediumPorosity = findViewById(R.id.rbMediumPorosity);
        rbHighPorosity = findViewById(R.id.rbHighPorosity);

        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        AtomicReference<List<Product>> everyProducts = new AtomicReference<>(dataBaseHelper.getProducts());
        AtomicReference<SingleProductListAdapter> singleProductListAdapter = new AtomicReference<>(new SingleProductListAdapter(ProductsActivity.this, R.layout.product_row, everyProducts.get()));
        listView.setAdapter(singleProductListAdapter.get());

        btnAddProduct.setOnClickListener(view -> {

            String productType = "";
            String type = "";
            String porosity = "";

            if (rbShampoo.isChecked()) {
                productType = rbShampoo.getText().toString();
            } else if (rbConditioner.isChecked()) {
                productType = rbConditioner.getText().toString();
            } else if (rbHairMask.isChecked()) {
                productType = rbHairMask.getText().toString();
            }

            if (!rbShampoo.isChecked()) {
                if (rbProtein.isChecked()) {
                    type = rbProtein.getText().toString();
                } else if (rbEmollient.isChecked()) {
                    type = rbEmollient.getText().toString();
                } else if (rbHumectant.isChecked()) {
                    type = rbHumectant.getText().toString();
                }
            } else {
                if (rbMild.isChecked()) {
                    type = rbMild.getText().toString();
                } else if (rbStrong.isChecked()) {
                    type = rbStrong.getText().toString();
                }
            }

            if (rbLowPorosity.isChecked()) {
                porosity = rbLowPorosity.getText().toString() + " porosity";
            } else if (rbMediumPorosity.isChecked()) {
                porosity = rbMediumPorosity.getText().toString() + " porosity";
            } else if (rbHighPorosity.isChecked()) {
                porosity = rbHighPorosity.getText().toString() + " porosity";
            }

            Product product = new Product(etProductName.getText().toString(), etProductComposition.getText().toString(), productType, type, porosity);
            dataBaseHelper.addProduct(product);
            everyProducts.set(dataBaseHelper.getProducts());

            singleProductListAdapter.set(new SingleProductListAdapter(ProductsActivity.this, R.layout.product_row, everyProducts.get()));
            listView.setAdapter(singleProductListAdapter.get());

            etProductName.setText("");
            etProductComposition.setText("");
            rgProductSpec.clearCheck();
            rgProductType.clearCheck();
            rgShampooType.clearCheck();
            rgPorosity.clearCheck();
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.porosityNavBar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    Intent intent1 = new Intent(ProductsActivity.this, HomeActivity.class);
                    startActivity(intent1);
                    item.setChecked(true);
                    break;

                case R.id.cosmetics:
                    Intent intent2 = new Intent(ProductsActivity.this, CosmeticsActivity.class);
                    startActivity(intent2);
                    item.setChecked(true);
                    break;

                case R.id.product:
                    item.setChecked(true);
                    break;

                case R.id.survey:
                    Intent intent4 = new Intent(ProductsActivity.this, SurveyActivity.class);
                    startActivity(intent4);
                    item.setChecked(true);
                    break;

                case R.id.settings:
                    Intent intent5 = new Intent(ProductsActivity.this, SettingsActivity.class);
                    startActivity(intent5);
                    item.setChecked(true);
                    break;
            }

            return false;
        });
    }
}