document.addEventListener("DOMContentLoaded", () => {
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
        <div class="card">
            <img src="${vehicle.immagine}" class="card-img-top" alt="${vehicle.descrizione}">
            <div class="card-body">
                <h5 class="card-title">Categoria: ${vehicle.categoria}</h5>
                <p class="card-text">
                    Alimentazione: ${vehicle.alimentazione}<br>
                    Indirizzo: ${vehicle.indirizzo}<br>
                    Descrizione: ${vehicle.descrizione}
                </p>
                ${vehicle.disponibile 
                    ? `<button class="btn btn-success">Prenota</button>` 
                    : `<span class="badge bg-danger">Non Disponibile</span>`}
            </div>
        </div>`;
});