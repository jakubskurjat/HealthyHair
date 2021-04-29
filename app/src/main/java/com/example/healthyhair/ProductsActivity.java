package com.example.healthyhair;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ProductsActivity extends AppCompatActivity {

    private Button btnAddProduct;
    private ListView listView;
    private EditText etProductName;
    private EditText etProductComposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        btnAddProduct = findViewById(R.id.btnAddProduct);
        listView = findViewById(R.id.listOfProducts);
        etProductName = findViewById(R.id.etProductName);
        etProductComposition = findViewById(R.id.etProductComposition);

        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        AtomicReference<List<Product>> everyProducts = new AtomicReference<>(dataBaseHelper.getProducts());
        AtomicReference<SingleProductListAdapter> singleProductListAdapter = new AtomicReference<>(new SingleProductListAdapter(ProductsActivity.this, R.layout.single_product_item, everyProducts.get()));
        listView.setAdapter(singleProductListAdapter.get());

        btnAddProduct.setOnClickListener(view -> {
            Product product = new Product(etProductName.getText().toString(), etProductComposition.getText().toString());
            dataBaseHelper.addProduct(product);
            everyProducts.set(dataBaseHelper.getProducts());

            singleProductListAdapter.set(new SingleProductListAdapter(ProductsActivity.this, R.layout.single_product_item, everyProducts.get()));
            listView.setAdapter(singleProductListAdapter.get());
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

                case R.id.productComposition:
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