import Autocomplete from '@mui/material/Autocomplete';
import * as React from 'react';
import {Helmet} from 'react-helmet-async';
import {TextField} from '@mui/material';
import {useEffect, useState} from "react";
import axios from "axios";
import {config} from "shelljs";


const options = [
    {label: 'Apple', id: 1},
    {label: 'Orange', id: 2},
];

type IngredientAutocompleteItem = {
    id: string,
    name: string
}

export function SearchRecipes() {
    const [ingredients, setIngredients] = useState<Array<IngredientAutocompleteItem>>([])

    async function getIngredients() {

        let {data: response} = await axios.get("http://localhost:8080/v1/ingredient")

        setIngredients(response.ingredients.map((ingredient) => {
            let ingredientAutocompleteItem: IngredientAutocompleteItem = {name: ingredient.name, id: ingredient.id};
            return ingredientAutocompleteItem
        }))
    }

    useEffect(() => {
        getIngredients()
    }, [])

    return (
        <>
            <Helmet>
                <title>Search Recipes</title>
                <meta name="description" content="Find your recipes"/>
            </Helmet>
            <Autocomplete
                multiple
                id="tags-outlined"
                options={ingredients}
                getOptionLabel={(option) => option.name}
                filterSelectedOptions
                renderInput={(params) => (
                    <TextField
                        {...params}
                        label="filterSelectedOptions"
                        placeholder="Ingredients"
                    />
                )}
            />
        </>
    );
}