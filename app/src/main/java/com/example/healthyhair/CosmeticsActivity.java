package com.example.healthyhair;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CosmeticsActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private AutoCompleteTextView autoCompleteTextView;
    private List<Cosmetic> data = new ArrayList<>();
    private RecyclerView recyclerView;
    private Button showCosmetics;
    private RadioGroup rgCosmeticsSpec;
    private RadioGroup rgCosmeticsType;
    private RadioGroup rgShampooType;
    private RadioGroup rgPorosity;
    private RadioButton rbShampoo;
    private RadioButton rbConditioner;
    private RadioButton rbHairMask;
    private RadioButton rbMild;
    private RadioButton rbStrong;
    private RadioButton rbProtein;
    private RadioButton rbEmollient;
    private RadioButton rbHumectant;
    private RadioButton rbLowPorosity;
    private RadioButton rbMediumPorosity;
    private RadioButton rbHighPorosity;
    private AutoCompleteTextView tvCosmeticName;

    private String[] cosmeticsName = {
            "ANWEN Orange & Bergamot.", "ONLY BIO Balanced shampoo.",
            "ANWEN Wake it up.", "GOSH Macadamia oil.",
            "ANWEN Protein magnolia.", "ANWEN Protein orchid.",
            "ONLY BIO Emollient conditioner.", "ANWEN Emollient acacia.",
            "EQUILIBRA Moisturizing conditioner with aloe.", "ANWEN Moisturizing lilac.",
            "ECOLAB Keratin hair mask.", "ECOLAB Hair mask with reconstruction with rose.",
            "ANWEN Coconut & Kaolin.", "BIOLAVEN Hair mask.",
            "CAFE MIMI Ceramides Hair Mask.", "CURLSMITH Hydro creme soothing mask."
    };

    private String[] cosmeticsComposition = {
            "Aqua, Sodium Cocoamphoacetate, Glycerin, Lauryl Glucoside, Betaine, Sodium Cocoyl Glutamate, Sodium Lauroyl Glucose Carboxylate, Epilobium Parviflorum Extract, Saponaria Officinalis Root Extract, Niacinamide, Acacia Conocinna Fruit Extract, Balanites Aegyptiaca Fruit Extract, Gypsophila Paniculata Root Extract, Zinc Gluconate, Coco-Glucoside, Glyceryl Oleate, Starch Hydroxypropyltrimonium Chloride, Citric Acid, Sodium Benzoate, Potassium Sorbate, Parfum, Benzyl Alcohol , Citral, Hydroxycitronellal, Limonene, Linalool.",
            "Aqua, Lauryl Glucoside, Sodium Cocoyl Isethionate, Coco-Glucoside, Glyceryl Oleate, Hydrolyzed Yeast Protein, Glycerin, Canola Oil, Arnica Montana Flower Extract, Calendula Officinalis Flower Extract, Guar Hydroxypropyltrimonium Chloride, Hydrogenated Palm Glycerides Citrate, Citric Acid, Sorbic Acid, Potassium Sorbate, Sodium Benzoate, Tocopherol, Parfum.",
            "Aqua, Urea, Sodium Laureth Sulfate, Coco-Glucoside, Acrylates Copolymer, Polysorbate 20, Cetrimonium Chloride, Propanediol, Glycerin, Propylene Glycol, Bacillus Ferment, Caffeine, Coffea Arabica Seed Extract, Dipotassium Glycyrrhizate, Disodium EDTA, Sodium Hydroxide, Citric Acid, Salicylic Acid, Sorbic Acid, Benzyl Alcohol, Parfum.",
            "Aqua, Sodium Laureth Sulfate, Sodium Laureth-11 Carboxylate, PEG-4 Rapeseedamide, Sodium Chloride, Glycerin, Macadamia Terniofolia Seed Oil, Hydroxypropyl Guar Hydroxypropyltrimonium Chloride, Panthenol, Glycol Distearate, Coco-Glucoside, Glyceryl Oleate, Glyceryl Stearate, Phenoxyethanol, Benzoic Acid, Dehydroacetic Acid, Ethylhexylglycerin, Parfum/Fragrance, Hexyl Cinnamal, Benzyl Salicylate, Citric Acid.",
            "Aqua, Cetearyl Alcohol, Behentrimonium Chloride, PPG-3 Benzyl Ether Myristate, Hydrolyzed Milk Protein (hydrolizowane proteiny mleczne), Hydrolyzed Oats (hydrolizowane proteiny owsa), Hydrolyzed Keratin (hydrolizowana keratyna), Cetrimonium Chloride, Starch Hydroxypropyltrimonium Chloride, Phenoxyethanol, Benzoic Acid, Dehydroacetic Acid, Parfum.",
            "Aqua, Cetearyl Alcohol, Behentrimonium Chloride, PPG-3 Benzyl Ether Myristate, Hydrolyzed Pea Protein (hydrolizowane proteiny grochu), Keratin (keratyna), Hydrolyzed Keratin (hydrolizowana keratyna), Collagen (kolagen), Hydrolyzed Elastin (hydrolizowana elastyna), Cetrimonium Chloride, Starch Hydroxypropyltrimonium Chloride, Phenoxyethanol, Benzoic Acid, Dehydroacetic Acid, Parfum, Butylphenyl Methylpropional, Benzyl Salicylate, Coumarin, Limonene, Geraniol, Linalool, Hexyl Cinnamal.",
            "Aqua, Cetearyl Alcohol, Butyrospermum Parkii (Shea) Butter, Behentrimonium Chloride, Linum Usitatissimum (Linseed) Seed Oil, Persea Gratissima (Avocado) Oil, Rubus Chamaemorus Fruit Extract, Tocopherol, Helianthus Annuus (Sunflower) Seed Oil, Guar Hydroxypropyltrimonium Chloride, Citric Acid, Cetrimonium Chloride, Benzyl Alcohol, Benzoic Acid, Dehydroacetic Acid, Parfum, Citronellol, Geraniol. Benzyl Alcohol, Dehydroacetic Acid, Benzoic Acid, Parfum, Linalool.",
            "Aqua, Orbignya Oleifera Seed Oil, Cetearyl Alcohol, Behentrimonium Chloride, Astrocaryum Murumuru Seed Butter, Caprylic/Capric Triglyceride, Starch Hydroxypropyltrimonium Chloride, Kaolin, Fucus Vesiculosus Extract, Cetrimonium Chloride, Phenoxyethanol, Benzoic Acid, Dehydroacetic Acid, BHT, Parfum.",
            "Aqua, Aloe Barbadensis Leaf Juice, Prunus Amygdalus Dulcis (Sweet Almond) Oil, Cetyl Alcohol, Myristyl Alcohol, Stearamidopropyl Dimethylamine, Linum Usitatissimum Seed Oil, Glycerin, Urtica Dioica (Nettle) Leaf Extract, Lecithin, Tocopherol, Sodium Phytate, Ascorbyl Palmitate, Citric Acid, Sodium Levulinate, Sodium Benzoate, Lactic Acid, Parfum (Fragrance).",
            "Aqua, Cetearyl Alcohol, Behentrimonium Chloride, Starch Hydroxypropyltrimonium Chloride, Solanum Tuberosum (Potato) Starch (skrobia ziemniaczana), Allium Cepa Extract (wyciąg z cebuli), Saccharide Isomerate, Hydroxypropyltrimonium Hyaluronate, Aloe Barbadensis (Aloe Vera) Leaf Juice Powder (sok aloesowy), Cetrimonium Chloride, Glycerin, Urea (mocznik), Polysorbate 80, Hydroxypropyl Guar, Citric Acid, Sodium Citrate, Phenoxyethanol, Benzoic Acid, Dehydroacetic Acid, Caprylyl Glycol, Parfum, Amyl Cinnamal, Cinnamyl Alcohol, Hydroxycitronellal.",
            "Aqua, Theobroma Grandiflorum Seed Butter, Cetearyl Alcohol, Behentrimonium Chloride, Butyrospermum Parkii (Shea) Butter, Caprylic/Capric Triglyceride, Persea Gratissima (Avocado) Oil, Hydrolyzed Keratin, Behentrimonium Chloride, Niacinamide, Calcium Pantothenate, Sodium Ascorbyl Phosphate, Tocopheryl Acetate, Pyridoxine HCl, Maltodextrin, Sodium Starch Octenylsuccinate, Glycerin, Cellulose, Betaine,Сetrimonium Chloride, Perfume, Benzyl Alcohol, Caprylyl Glycol, Silica, Citric Acid, Sodium Benzoate, Potassium Sorbate.",
            "Aqua, Rosa Canina Floral Water (woda różana), Organic Simmondsia Chinensis Oil (organiczny olej jojoba), Camelina Sativa Seed Oil (olej z lnicznika siewnego), Organic Bambusa Аrundinacea Еxtract (organiczny ekstrakt z bambusa), Saccharomyces Сerevisiae Еxtract (drożdże), Cananga Extract (ylang ylang), Glycerin, Behenamidopropyl Dimethylamine, Glyceryl Monostearate, Hydrolyzed Silk Peptides (proteiny jedwabiu), Macadamia Integrifolia Seed Oil (olej makadamii), Glyceryl Stearate SE, Borago Seed Oil Rafined (olej z nasion ogórecznika), Perfume, Lactic Acid, Benzoic Acid,Sorbic Acid, Dehydroacetic Acid.",
            "Aqua, Cetearyl Alcohol, Kaolin (glinka biała), Behentrimonium Chloride, Cocos Nuciefera (Coconut) Oil (olej kokosowy), Glycerin, Orbignya Oleifera Seed Oil (olej babassu), Panthenol, Cysteine HCl, Arginine, Sodium Hyaluronate (kwas hialuronowy), Phenoxyethanol, Benzoic Acid, Dehydroacetic Acid, Parfum, Limonene, Citronellol, Geraniol, Linalool.",
            "Aqua, Cetyl Alcohol, Vitis Vinifera Seed Oil, Glycerin, Vitis Vinifera Skin Powder, Stearic Acid, Persea Gratissima Butter, Squalane, Panthenol, Isoamyl Laurate, Isoamyl Cocoate, Tocopheryl Acetate, Cyamopsis Tetragonoloba Gum, Glyceryl Laurate, Lactic Acid, Decyl Glucoside, Cocamidopropyl Betaine, Lavandula Angustifolia Oil, Sodium Benzoate, Parfum, Linalool.",
            "Aqua, Jasminum Officinale (Jasmine) Flower Water, Cetearyl Alcohol, Vegetable Glyсerin, Aloe Barbadensis (Aloe Vera) Leaf Juice, Hamamelis Virginiana (Whitch Hazel) Extract, Prunus Amygdalus Dulcis (Sweet Almond) Oil, Caprylic/Capric Triglyceride, Behentrimonium Chloride, Ceramide NG, PEG -7 Glyceryl Cocoate, PEG- 60 Hydrogenated Castor oil, Hydroxyethylcellulose, Panthenol, Perfume, Gluconolactone, Sodium Benzoate,  Hydroxypropyl Guar, Hydroxypropyltrimonium chloride, Silicone Quaternium-18, Trideceth-6, Trideceth-12, Polyquaternium-10, Benzyl Alcohol, Benzoic Acid, Dehydroacetic Acid, Potassium Sorbate, Citric Acid,  Hydroxycitronellal, Linalool, Coumarin, Amyl Cinnamal, Hexyl Cinnamal.",
            "Aqua, Cetearyl Alcohol (Plant Derived), Propanediol, Behentrimonium Chloride, Hydroxypropyl Starch Phosphate, Cetyl Esters, Guar Hydroxypropyltrimonium Chloride, Sodium Hyaluronate, Lavandula Angustifolia (Lavender) Flower Extract, Camellia Sinensis (Green Tea) Leaf Extract, Thymus Vulgaris (Thyme) Leaf Extract, Phyllanthus Emblica (Amla) Fruit Extract, Cedrus Atlantica (Cedar Wood) Extract, Hamamelis Virginiana (Witch Hazel) Leaf Extract, Butyrospermum Parkii (Shea Butter), Glycerin, Panthenol, Ethylhexylglycerin, Citric Acid, Disodium Edta, Sodium Hydroxide, Potassium Sorbate, Sodium Benzoate, Phenoxyethanol, Linalool, Limonene, Citronellol, Fragrance (Parfum)."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmetics);

        autoCompleteTextView = findViewById(R.id.acTVCosmeticName);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, cosmeticsName);
        autoCompleteTextView.setAdapter(adapter);

        bottomNavigationView = findViewById(R.id.porosityNavBar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    Intent intent1 = new Intent(CosmeticsActivity.this, HomeActivity.class);
                    startActivity(intent1);
                    item.setChecked(true);
                    break;

                case R.id.cosmetics:
                    item.setChecked(true);
                    break;

                case R.id.product:
                    Intent intent3 = new Intent(CosmeticsActivity.this, ProductsActivity.class);
                    startActivity(intent3);
                    item.setChecked(true);
                    break;

                case R.id.survey:
                    Intent intent4 = new Intent(CosmeticsActivity.this, SurveyActivity.class);
                    startActivity(intent4);
                    item.setChecked(true);
                    break;

                case R.id.settings:
                    Intent intent5 = new Intent(CosmeticsActivity.this, SettingsActivity.class);
                    startActivity(intent5);
                    item.setChecked(true);
                    break;
            }

            return false;
        });

        addDataToList();
        tvCosmeticName = findViewById(R.id.acTVCosmeticName);
        rgCosmeticsSpec = findViewById(R.id.rgCosmeticSpec);
        rgCosmeticsType = findViewById(R.id.rgCosmeticType);
        rgShampooType = findViewById(R.id.rgShampooType);
        rgPorosity = findViewById(R.id.rgPorosity);
        showCosmetics = findViewById(R.id.btnShowCosmetics);
        rbShampoo = findViewById(R.id.rbShampoo);
        rbConditioner = findViewById(R.id.rbConditioner);
        rbHairMask = findViewById(R.id.rbHairMask);
        rbMild = findViewById(R.id.rbMild);
        rbStrong = findViewById(R.id.rbStrong);
        rbProtein = findViewById(R.id.rbProtein);
        rbEmollient = findViewById(R.id.rbEmollient);
        rbHumectant = findViewById(R.id.rbHumectant);
        rbLowPorosity = findViewById(R.id.rbLowPorosity);
        rbMediumPorosity = findViewById(R.id.rbMediumPorosity);
        rbHighPorosity = findViewById(R.id.rbHighPorosity);

        showCosmetics.setOnClickListener(view -> {

            data.clear();
            addDataToList();

            if (tvCosmeticName.getText().toString().equals("")) {

                if (rbShampoo.isChecked() || rbConditioner.isChecked() || rbHairMask.isChecked() ||
                        rbMild.isChecked() || rbStrong.isChecked() ||
                        rbProtein.isChecked() || rbEmollient.isChecked() || rbHumectant.isChecked() ||
                        rbLowPorosity.isChecked() || rbMediumPorosity.isChecked() || rbHighPorosity.isChecked()) {

                    if (rbShampoo.isChecked()) {
                        List<Cosmetic> cosmetics1 = data.stream().filter(c -> c.getCosmeticSpec().equals("Shampoo")).collect(Collectors.toList());
                        data.clear();
                        data.addAll(cosmetics1);

                        if (rbMild.isChecked()) {
                            List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticType().equals("Mild")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics2);

                        } else if (rbStrong.isChecked()) {
                            List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticType().equals("Strong")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics2);
                        }

                        if (rbProtein.isChecked() || rbEmollient.isChecked() || rbHumectant.isChecked()) {
                            data.clear();
                        }

                    } else if (rbConditioner.isChecked()) {
                        List<Cosmetic> cosmetic1 = data.stream().filter(c -> c.getCosmeticSpec().equals("Conditioner")).collect(Collectors.toList());
                        data.clear();
                        data.addAll(cosmetic1);

                        if (rbProtein.isChecked()) {
                            List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticType().equals("Protein")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics2);

                        } else if (rbEmollient.isChecked()) {
                            List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticType().equals("Emollient")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics2);

                        } else if (rbHumectant.isChecked()) {
                            List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticType().equals("Humectant")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics2);
                        }

                        if (rbLowPorosity.isChecked()) {
                            List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("Low porosity")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics2);

                        } else if (rbMediumPorosity.isChecked()) {
                            List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("Medium porosity")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics2);

                        } else if (rbHighPorosity.isChecked()) {
                            List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("High porosity")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics2);
                        }

                        if (rbMild.isChecked() || rbStrong.isChecked()) {
                            data.clear();
                        }

                    } else if (rbHairMask.isChecked()) {
                        List<Cosmetic> cosmetic1 = data.stream().filter(c -> c.getCosmeticSpec().equals("Mask")).collect(Collectors.toList());
                        data.clear();
                        data.addAll(cosmetic1);

                        if (rbProtein.isChecked()) {
                            List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticType().equals("Protein")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics2);

                        } else if (rbEmollient.isChecked()) {
                            List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticType().equals("Emollient")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics2);

                        } else if (rbHumectant.isChecked()) {
                            List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticType().equals("Humectant")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics2);
                        }

                        if (rbLowPorosity.isChecked()) {
                            List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("Low porosity")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics2);

                        } else if (rbMediumPorosity.isChecked()) {
                            List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("Medium porosity")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics2);

                        } else if (rbHighPorosity.isChecked()) {
                            List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("High porosity")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics2);
                        }

                        if (rbMild.isChecked() || rbStrong.isChecked()) {
                            data.clear();
                        }
                    }

                    if (rbProtein.isChecked()) {
                        List<Cosmetic> cosmetics = data.stream().filter(c -> c.getCosmeticType().equals("Protein")).collect(Collectors.toList());
                        data.clear();
                        data.addAll(cosmetics);

                    } else if (rbEmollient.isChecked()) {
                        List<Cosmetic> cosmetics = data.stream().filter(c -> c.getCosmeticType().equals("Emollient")).collect(Collectors.toList());
                        data.clear();
                        data.addAll(cosmetics);

                    } else if (rbHumectant.isChecked()) {
                        List<Cosmetic> cosmetics = data.stream().filter(c -> c.getCosmeticType().equals("Humectant")).collect(Collectors.toList());
                        data.clear();
                        data.addAll(cosmetics);
                    } else if (rbMild.isChecked()) {
                        List<Cosmetic> cosmetics = data.stream().filter(c -> c.getCosmeticType().equals("Mild")).collect(Collectors.toList());
                        data.clear();
                        data.addAll(cosmetics);
                    } else if (rbStrong.isChecked()) {
                        List<Cosmetic> cosmetics = data.stream().filter(c -> c.getCosmeticType().equals("Strong")).collect(Collectors.toList());
                        data.clear();
                        data.addAll(cosmetics);
                    }

                    if (rbLowPorosity.isChecked()) {
                        List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("Low porosity")).collect(Collectors.toList());
                        data.clear();
                        data.addAll(cosmetics2);

                    } else if (rbMediumPorosity.isChecked()) {
                        List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("Medium porosity")).collect(Collectors.toList());
                        data.clear();
                        data.addAll(cosmetics2);

                    } else if (rbHighPorosity.isChecked()) {
                        List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("High porosity")).collect(Collectors.toList());
                        data.clear();
                        data.addAll(cosmetics2);
                    }
                }

            } else {
                Optional<Cosmetic> cosmetic = data.stream().filter(c -> c.getCosmeticName().equals(tvCosmeticName.getText().toString())).findAny();

                if (cosmetic.isPresent()) {
                    data.clear();
                    data.add(cosmetic.get());

                    if (rbShampoo.isChecked() || rbConditioner.isChecked() || rbHairMask.isChecked() ||
                            rbMild.isChecked() || rbStrong.isChecked() ||
                            rbProtein.isChecked() || rbEmollient.isChecked() || rbHumectant.isChecked() ||
                            rbLowPorosity.isChecked() || rbMediumPorosity.isChecked() || rbHighPorosity.isChecked()) {

                        if (rbShampoo.isChecked()) {
                            List<Cosmetic> cosmetics1 = data.stream().filter(c -> c.getCosmeticSpec().equals("Shampoo")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics1);

                            if (rbMild.isChecked()) {
                                List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticType().equals("Mild")).collect(Collectors.toList());
                                data.clear();
                                data.addAll(cosmetics2);

                            } else if (rbStrong.isChecked()) {
                                List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticType().equals("Strong")).collect(Collectors.toList());
                                data.clear();
                                data.addAll(cosmetics2);
                            }

                            if (rbProtein.isChecked() || rbEmollient.isChecked() || rbHumectant.isChecked()) {
                                data.clear();
                            }

                        } else if (rbConditioner.isChecked()) {
                            List<Cosmetic> cosmetic1 = data.stream().filter(c -> c.getCosmeticSpec().equals("Conditioner")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetic1);

                            if (rbProtein.isChecked()) {
                                List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticType().equals("Protein")).collect(Collectors.toList());
                                data.clear();
                                data.addAll(cosmetics2);

                            } else if (rbEmollient.isChecked()) {
                                List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticType().equals("Emollient")).collect(Collectors.toList());
                                data.clear();
                                data.addAll(cosmetics2);

                            } else if (rbHumectant.isChecked()) {
                                List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticType().equals("Humectant")).collect(Collectors.toList());
                                data.clear();
                                data.addAll(cosmetics2);
                            }

                            if (rbLowPorosity.isChecked()) {
                                List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("Low porosity")).collect(Collectors.toList());
                                data.clear();
                                data.addAll(cosmetics2);

                            } else if (rbMediumPorosity.isChecked()) {
                                List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("Medium porosity")).collect(Collectors.toList());
                                data.clear();
                                data.addAll(cosmetics2);

                            } else if (rbHighPorosity.isChecked()) {
                                List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("High porosity")).collect(Collectors.toList());
                                data.clear();
                                data.addAll(cosmetics2);
                            }

                            if (rbMild.isChecked() || rbStrong.isChecked()) {
                                data.clear();
                            }

                        } else if (rbHairMask.isChecked()) {
                            List<Cosmetic> cosmetic1 = data.stream().filter(c -> c.getCosmeticSpec().equals("Mask")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetic1);

                            if (rbProtein.isChecked()) {
                                List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticType().equals("Protein")).collect(Collectors.toList());
                                data.clear();
                                data.addAll(cosmetics2);

                            } else if (rbEmollient.isChecked()) {
                                List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticType().equals("Emollient")).collect(Collectors.toList());
                                data.clear();
                                data.addAll(cosmetics2);

                            } else if (rbHumectant.isChecked()) {
                                List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticType().equals("Humectant")).collect(Collectors.toList());
                                data.clear();
                                data.addAll(cosmetics2);
                            }

                            if (rbLowPorosity.isChecked()) {
                                List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("Low porosity")).collect(Collectors.toList());
                                data.clear();
                                data.addAll(cosmetics2);

                            } else if (rbMediumPorosity.isChecked()) {
                                List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("Medium porosity")).collect(Collectors.toList());
                                data.clear();
                                data.addAll(cosmetics2);

                            } else if (rbHighPorosity.isChecked()) {
                                List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("High porosity")).collect(Collectors.toList());
                                data.clear();
                                data.addAll(cosmetics2);
                            }

                            if (rbMild.isChecked() || rbStrong.isChecked()) {
                                data.clear();
                            }
                        }

                        if (rbProtein.isChecked()) {
                            List<Cosmetic> cosmetics = data.stream().filter(c -> c.getCosmeticType().equals("Protein")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics);

                        } else if (rbEmollient.isChecked()) {
                            List<Cosmetic> cosmetics = data.stream().filter(c -> c.getCosmeticType().equals("Emollient")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics);

                        } else if (rbHumectant.isChecked()) {
                            List<Cosmetic> cosmetics = data.stream().filter(c -> c.getCosmeticType().equals("Humectant")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics);
                        } else if (rbMild.isChecked()) {
                            List<Cosmetic> cosmetics = data.stream().filter(c -> c.getCosmeticType().equals("Mild")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics);
                        } else if (rbStrong.isChecked()) {
                            List<Cosmetic> cosmetics = data.stream().filter(c -> c.getCosmeticType().equals("Strong")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics);
                        }

                        if (rbLowPorosity.isChecked()) {
                            List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("Low porosity")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics2);

                        } else if (rbMediumPorosity.isChecked()) {
                            List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("Medium porosity")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics2);

                        } else if (rbHighPorosity.isChecked()) {
                            List<Cosmetic> cosmetics2 = data.stream().filter(c -> c.getCosmeticPorosity().equals("Universal porosity") || c.getCosmeticPorosity().equals("High porosity")).collect(Collectors.toList());
                            data.clear();
                            data.addAll(cosmetics2);
                        }
                    }

                } else {
                    data.clear();
                }
            }

            recyclerView = findViewById(R.id.cosmeticsRecView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(new RecyclerViewAdapter(CosmeticsActivity.this, data));
            recyclerView.setLayoutManager(new LinearLayoutManager(CosmeticsActivity.this));

            clearAllFilters();
        });

        recyclerView =

                findViewById(R.id.cosmeticsRecView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new

                RecyclerViewAdapter(CosmeticsActivity.this, data));
        recyclerView.setLayoutManager(new

                LinearLayoutManager(CosmeticsActivity.this));
    }

    private void addDataToList() {
        data.add(new Cosmetic(cosmeticsName[0], "Shampoo", "Mild", cosmeticsComposition[0], "Universal porosity", R.drawable.anwen_orange_bergamot));
        data.add(new Cosmetic(cosmeticsName[1], "Shampoo", "Mild", cosmeticsComposition[1], "Universal porosity", R.drawable.only_bio_balanced_shampoo));
        data.add(new Cosmetic(cosmeticsName[2], "Shampoo", "Strong", cosmeticsComposition[2], "Universal porosity", R.drawable.anwen_wake_it_up));
        data.add(new Cosmetic(cosmeticsName[3], "Shampoo", "Strong", cosmeticsComposition[3], "Universal porosity", R.drawable.gosh_macadamia_oil));
        data.add(new Cosmetic(cosmeticsName[4], "Conditioner", "Protein", cosmeticsComposition[4], "Medium porosity", R.drawable.anwen_protein_magnolia));
        data.add(new Cosmetic(cosmeticsName[5], "Conditioner", "Protein", cosmeticsComposition[5], "High porosity", R.drawable.anwen_protein_orchid));
        data.add(new Cosmetic(cosmeticsName[6], "Conditioner", "Emollient", cosmeticsComposition[6], "Medium porosity", R.drawable.only_bio_emollient_conditioner));
        data.add(new Cosmetic(cosmeticsName[7], "Conditioner", "Emollient", cosmeticsComposition[7], "Low porosity", R.drawable.anwen_emollient_acacia));
        data.add(new Cosmetic(cosmeticsName[8], "Conditioner", "Humectant", cosmeticsComposition[8], "Medium porosity", R.drawable.equalibra_moisturizing_conditioner));
        data.add(new Cosmetic(cosmeticsName[9], "Conditioner", "Humectant", cosmeticsComposition[9], "Universal porosity", R.drawable.anwen_moisturizing_conditioner));
        data.add(new Cosmetic(cosmeticsName[10], "Mask", "Protein", cosmeticsComposition[10], "Low porosity", R.drawable.ecolab_keratin_hair_mask));
        data.add(new Cosmetic(cosmeticsName[11], "Mask", "Protein", cosmeticsComposition[11], "Porosity", R.drawable.ecolab_rose_hair_mask));
        data.add(new Cosmetic(cosmeticsName[12], "Mask", "Emollient", cosmeticsComposition[12], "Low porosity", R.drawable.anwen_coconut_kaolin));
        data.add(new Cosmetic(cosmeticsName[13], "Mask", "Emollient", cosmeticsComposition[13], "Medium porosity", R.drawable.biolaven_hair_mask));
        data.add(new Cosmetic(cosmeticsName[14], "Mask", "Humectant", cosmeticsComposition[14], "Medium porosity", R.drawable.cafe_mini_ceramides_hair_mask));
        data.add(new Cosmetic(cosmeticsName[15], "Mask", "Humectant", cosmeticsComposition[15], "Medium porosity", R.drawable.curlsmith_hydro_creme));
    }

    private void clearAllFilters() {
        tvCosmeticName.setText("");
        rgCosmeticsSpec.clearCheck();
        rgShampooType.clearCheck();
        rgCosmeticsType.clearCheck();
        rgPorosity.clearCheck();
    }
}