/*document.addEventListener("DOMContentLoaded", () => {
    // Simulazione dei dati dei veicoli
    const vehicles = [
        {
            id: 1,
            categoria: "Auto",
            alimentazione: "Diesel",
            indirizzo: "Via Roma, Torino",
            immagine: "https://via.placeholder.com/400x200",
            descrizione: "Fiat Panda 1200cc, colore blu",
            disponibile: true,
            gps: { lat: 45.0703, lng: 7.6869 }
        },
        {
            id: 2,
            categoria: "Bicicletta",
            alimentazione: "Elettrico",
            indirizzo: "Corso Francia, Torino",
            immagine: "https://via.placeholder.com/400x200",
            descrizione: "Mountain Bike elettrica, colore rosso",
            disponibile: false,
            gps: { lat: 45.0767, lng: 7.6761 }
        }
    ];

    // Funzione per ottenere l'ID dal parametro GET
    function getVehicleId() {
        const params = new URLSearchParams(window.location.search);
        return parseInt(params.get("id"), 10); // Converte l'ID in un intero
    }
    console.log("Vehicle ID:", vehicleId);

    // Ottieni l'ID del veicolo
    const vehicleId = getVehicleId();

    if (!vehicleId) {
        // Se non c'è un ID valido, reindirizza alla home
        window.location.href = "index.html";
        return;
    }

    // Trova il veicolo corrispondente
    const vehicle = vehicles.find(v => v.id === vehicleId);

    if (!vehicle) {
        // Se il veicolo non esiste, mostra un errore
        document.getElementById("vehicle-info").innerHTML = `
            <div class="alert alert-danger" role="alert">
                Veicolo non trovato!
            </div>`;
        return;
    }

    // Aggiungi i dettagli del veicolo alla pagina
    const vehicleInfoContainer = document.getElementById("vehicle-info");
    vehicleInfoContainer.innerHTML = `
          <div class="card vehicle-card shadow-sm">
        <img src="${vehicle.immagine}" class="card-img-top" alt="${vehicle.descrizione}">
        <div class="card-body">
        <h5 class="card-title text-primary">Categoria: ${vehicle.categoria}</h5>
            <p class="card-text mb-2">
                <strong>Alimentazione:</strong> ${vehicle.alimentazione}<br>
                <strong>Indirizzo:</strong> ${vehicle.indirizzo}<br>
                <strong>Descrizione:</strong> ${vehicle.descrizione}
            </p>
        ${vehicle.disponibile 
            ? `<button class="btn btn-success w-100">Prenota</button>` 
            : `<span class="badge bg-danger d-block w-100 py-2">Non Disponibile</span>`}
  </div>
</div>`
});
*/
document.addEventListener("DOMContentLoaded", () => {
    // Dati fake dei veicoli
    const vehicles = [
        {
            id: 1,
            categoria: "Auto",
            alimentazione: "Diesel",
            indirizzo: "Via Roma, Torino",
            immagine: "https://via.placeholder.com/400x200",
            descrizione: "Fiat Panda 1200cc, colore blu",
            disponibile: true,
        },
        {
            id: 2,
            categoria: "Bicicletta",
            alimentazione: "Elettrico",
            indirizzo: "Corso Francia, Torino",
            immagine: "https://via.placeholder.com/400x200",
            descrizione: "Mountain Bike elettrica, colore rosso",
            disponibile: false,
        }
    ];

    // ID del veicolo fake (prova con ID=1)
    const vehicleId = 1; // Cambia a 2 o altro per testare

    // Trova il veicolo corrispondente
    const vehicle = vehicles.find(v => v.id === vehicleId);

    // Ottieni il contenitore e mostra i dettagli
    const vehicleInfoContainer = document.getElementById("vehicle-info");

    if (vehicle) {
        // Veicolo trovato: Mostra la card
        //immagine di prova, sostituire con ${vehicle.immagine}
        vehicleInfoContainer.innerHTML = `
            <div class="card vehicle-card shadow-sm">
                <img src="./img/MrBean.jpg" class="card-img-top" alt="${vehicle.descrizione}">
                <div class="card-body">
                    <h5 class="card-title">${vehicle.descrizione}</h5>
                    <p class="card-text mb-2">
                        <strong>Alimentazione:</strong> ${vehicle.alimentazione}<br>
                        <strong>Indirizzo:</strong> ${vehicle.indirizzo}<br>
                    </p>
                    ${vehicle.disponibile 
                        ? `<button class="btn btn-success" style="width:200px">Prenota</button>` 
                        : `<span class="badge bg-danger d-block w-100 py-2">Non Disponibile</span>`}
                </div>
            </div>
        `;
    } else {
        // Veicolo non trovato
        vehicleInfoContainer.innerHTML = `
            <div class="alert alert-danger" role="alert">
                Veicolo non trovato!
            </div>
        `;
    }
});