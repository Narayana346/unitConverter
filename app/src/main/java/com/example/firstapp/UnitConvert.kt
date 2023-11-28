package com.example.firstapp

class UnitConvert(){
    public fun convert(unitFrom: String, unitTo: String, value: Double?): Double {
        // Add your conversion logic here
        val metersToFeetConversionFactor = 3.28084
        val metersToCentimeterConversionFactor = 100
        val kilogramsToPoundsConversionFactor = 2.2
        val kilogramsToGramsConversionFactor = 1000
        val litersToGallonConversionFactor = 0.264172
        val litersToMillimeterConversionFactor = 1000
        return when {
            unitFrom == "Meter" && unitTo == "Foot" -> value!! * metersToFeetConversionFactor
            unitFrom == "Foot" && unitTo == "Meter" -> value!! / metersToFeetConversionFactor
            unitFrom == "Meter" && unitTo == "Centimeter" -> value!! * metersToCentimeterConversionFactor
            unitFrom == "Centimeter" && unitTo == "Meter" -> value!! / metersToCentimeterConversionFactor
            unitFrom == "Foot" && unitTo == "Centimeter" -> value!! * 30.48
            unitFrom == "Centimeter" && unitTo == "Foot" -> value!! / 30.48

            unitFrom == "Kilogram" && unitTo == "Pound" -> value!! * kilogramsToPoundsConversionFactor
            unitFrom == "Pound" && unitTo == "Kilogram" -> value!! / kilogramsToPoundsConversionFactor
            unitFrom == "Kilogram" && unitTo == "Grams" -> value!! * kilogramsToGramsConversionFactor
            unitFrom == "Grams" && unitTo == "Kilogram" -> value!! / kilogramsToGramsConversionFactor
            unitFrom == "Pound" && unitTo == "Grams" -> value!! * 453.592
            unitFrom == "Grams" && unitTo == "Pound" -> value!! / 453.6


            unitFrom == "Liters" && unitTo == "Gallon" -> value!! * litersToGallonConversionFactor
            unitFrom == "Gallon" && unitTo == "Liters" -> value!! / litersToGallonConversionFactor
            unitFrom == "Liters" && unitTo == "Milliliters" -> value!! * litersToMillimeterConversionFactor
            unitFrom == "Milliliters" && unitTo == "Liters" -> value!! / litersToMillimeterConversionFactor
            unitFrom == "Gallon" && unitTo == "Milliliters" -> value!! * 3785.41
            unitFrom == "Milliliters" && unitTo == "Gallon" -> value!! / 3785.41

            else -> value ?: 0.0
        }
    }

}