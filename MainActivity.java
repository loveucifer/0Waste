package com.example.a0wasted;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText ingredientsEditText;
    private TextView recipeTextView;
    private Button generateRecipeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ingredientsEditText = findViewById(R.id.ingredientsEditText);
        recipeTextView = findViewById(R.id.recipeTextView);
        generateRecipeButton = findViewById(R.id.generateRecipeButton);

        generateRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ingredients = ingredientsEditText.getText().toString();
                String recipe = generateRecipe(ingredients);
                recipeTextView.setText(recipe);
            }
        });
    }

    private String generateRecipe(String ingredients) {
        if (ingredients.isEmpty()) {
            return "Please enter some ingredients.";
        }

        String[] ingredientsArray = ingredients.split(",");
        StringBuilder recipe = new StringBuilder("<ul>");

        for (String ingredient : ingredientsArray) {
            recipe.append("<li>Use ").append(ingredient.trim()).append(" to make a delicious dish.</li>");
        }

        recipe.append("</ul>");
        return recipe.toString();
    }
}