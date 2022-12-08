fun main() {
    fun findFirstMarker(data: String): Int {
        // Lista för att hålla de fyra senast mottagna tecknen
        val marker = mutableListOf("", "", "", "")

        // Räknare för antal behandlade tecken
        var count = 0

        // Loop genom varje tecken i datastreamen
        for (ch in data) {
            // Lägg till tecknet i början av listan
            marker.add(0, ch.toString())

            // Ta bort det sista tecknet i listan
            marker.removeAt(4)

            // Öka räknaren för behandlade tecken
            count++

            // Om alla tecken i listan är unika, så har vi hittat en marker
            if (marker.filter { it != "" }.distinct().size == 4) {
                return count
            }
        }

        // Om ingen marker hittades, så returnerar vi -1
        return -1
    }

// Testkod
    val testData = "bvwbjplbgvbhsrlpgdmjqwftvncz"
    val firstMarker = findFirstMarker(testData)
    println("Första marker efter tecken $firstMarker")
}