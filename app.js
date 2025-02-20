document.getElementById('generate-recipe').addEventListener('click', () => {
    const ingredients = document.getElementById('ingredients').value.split(',').map(item => item.trim());
    const recipe = generateRecipe(ingredients);
    document.getElementById('recipe').innerHTML = recipe;
});

function generateRecipe(ingredients) {
    if (ingredients.length === 0) {
        return '<p>Please enter some ingredients.</p>';
    }
    
    let recipe = '<ul>';
    ingredients.forEach(ingredient => {
        recipe += `<li>Use ${ingredient} to make a delicious dish.</li>`;
    });
    recipe += '</ul>';
    
    return recipe;
}