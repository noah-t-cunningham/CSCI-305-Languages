data class city(val name: String, val lat: Double, val lon: Double)
val cityList: MutableList<city> = mutableListOf()
val distanceList: MutableList<Double> = mutableListOf()

fun listCities(): List<city>{
   val Atlanta = city("Atlanta", 33.7490, -84.3880)
   val Bozeman = city("Bozeman", 45.6770, -111.0429)
   val NewYork = city("New York", 40.7128, -74.0060)
   val SanFrancisco = city("San Francisco",37.7749, -122.4194)
   val Tacoma = city("Tacoma", 47.2529,  -122.4443)
   cityList.add(Atlanta)
   cityList.add(Bozeman)
   cityList.add(NewYork)
   cityList.add(SanFrancisco)
   cityList.add(Tacoma)
   return cityList
}

fun distanceFromSea(city1: city, city2: city): Double{
    val lat1 = city1.component2()
    val lon1 = city1.component3()
    val lat2 = city2.component2()
    val lon2 = city2.component3()
    val R = 6372.8 // in kilometers    
    val l1 = Math.toRadians(lat1)    
    val l2 = Math.toRadians(lat2)    
    val dl = Math.toRadians(lat2 - lat1)    
    val dr = Math.toRadians(lon2 - lon1)    
    val distance = 2 * R * Math.asin(Math.sqrt(Math.pow(Math.sin(dl / 2), 2.0) +
        Math.pow(Math.sin(dr / 2), 2.0) * Math.cos(l1) * Math.cos(l2)))
    return distance
    //return "${city1.component1()} is $distance km from ${city2.component1()}"

}

fun farFromSea(city1: city, Seattle: city): Boolean{
    if (distanceFromSea(city1, Seattle) > 1000){
        return true
    }
    else{
        return false
    }
}

fun main(){

    val cityLocations=listCities()
    
    val Seattle = city("Seattle", 47.6062, -122.3321)
    
    println("--------------STEP TWO-------------")
    for(i in cityLocations){
    	println(i)
		}

    val dis1 = distanceFromSea(cityLocations[4], Seattle)
    
    println("--------------STEP THREE-------------")
    println("${cityLocations[4].component1()} is $dis1 km from ${Seattle.component1()}")
    
    val distance = cityLocations.map{distanceFromSea(it, Seattle)}
    
    println("--------------STEP FOUR-------------")
    println("New List with all the Distances From Seattle $distance")
    
    val over1000 = cityLocations.filter{farFromSea(it, Seattle) == true}
    println("--------------STEP FIVE-------------")
    println("List of cities over 1000km away from Seattle")
    for (i in over1000){
            println(i.component1())
    	}
    
    val west = cityLocations.filter{it.lon < -89.97803}
    
    val names = west.map {it.name} 
	
    println("--------------STEP SIX-------------")
    println(names)
    
    var farthest = cityLocations.maxBy { it ->  distanceFromSea(it, Seattle) }
    
    println("--------------STEP SEVEN-------------")
    println("Max Distance From Seattle $farthest")
    
    var mappedCities: MutableMap<String, city> = mutableMapOf()
    
    for (i in cityLocations){
        mappedCities.put(i.component1(), i)
    	}
    
    println("--------------STEP EIGHT-------------")
    mappedCities.forEach {                                                              
        n, city -> println("Name $n: City $city")
    }
   
    if (mappedCities.containsKey("Bozeman")){
        
        println("The Latitude of Bozeman is ${mappedCities.getValue("Bozeman").component2()}")
    }
}