console.log("Script loaded correctly");


document.addEventListener("DOMContentLoaded", () => {
    new Swiper('.swiper-container', {
        loop: true,
        autoplay: {
            delay: 3000,
        },
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
    });
});


document.addEventListener("DOMContentLoaded", () => {
    // Simulazione dei veicoli disponibili
    const availableVehicles = [
        {
            id: 1,
            categoria: "Auto",
            alimentazione: "Diesel",
            indirizzo: "Via Roma, Torino",
            immagine: "car1.jpg",
            descrizione: "Fiat Panda 1200cc, colore blu",
        },
        {
            id: 2,
            categoria: "Bicicletta",
            alimentazione: "Elettrico",
            indirizzo: "Corso Francia, Torino",
            immagine: "bike1.jpg",
            descrizione: "Mountain Bike elettrica, colore rosso",
        },
        {
            id: 3,
            categoria: "Monopattino",
            alimentazione: "Elettrico",
            indirizzo: "Piazza Castello, Torino",
            immagine: "scooter1.jpg",
            descrizione: "Monopattino Xiaomi Pro 2",
        }
    ];

    // Simulazione dei veicoli in noleggio
    const rentedVehicles = [
        {
            id: 4,
            categoria: "Auto",
            alimentazione: "Ibrida",
            indirizzo: "Via Milano, Torino",
            immagine: "car2.jpg",
            descrizione: "Toyota Prius Hybrid",
        }
    ];

    // Popola la sezione "Veicoli Disponibili"
    const availableContainer = document.getElementById("available-vehicles");
    availableVehicles.forEach(vehicle => {
        availableContainer.innerHTML += `
            <div class="col-md-4 vehicle-card">
                <div class="card">
                    <img src="./img/vecteezy_car-automobile-vehicle-abstract-driving-logo_51766749.png" class="card-img-top" alt="${vehicle.descrizione}">
                    <div class="card-body">
                        <h5 class="card-title">Categoria: ${vehicle.categoria}</h5>
                        <p class="card-text">
                            <strong>Alimentazione:</strong> ${vehicle.alimentazione}<br>
                            <strong>Indirizzo:</strong> ${vehicle.indirizzo}
                        </p>
                        <a href="veicolo.html?id=${vehicle.id}" class="btn btn-danger">Dettagli</a>
                    </div>
                </div>
            </div>`;
    });

    // Popola la sezione "Veicoli in Noleggio"
    const rentedContainer = document.getElementById("rented-vehicles");
    rentedVehicles.forEach(vehicle => {
        rentedContainer.innerHTML += `
            <div class="col-md-4 vehicle-card">
                <div class="card">
                    <img src="${vehicle.immagine}" class="card-img-top" alt="${vehicle.descrizione}">
                    <div class="card-body">
                        <h5 class="card-title">Categoria: ${vehicle.categoria}</h5>
                        <p class="card-text">
                            <strong>Alimentazione:</strong> ${vehicle.alimentazione}<br>
                           <strong>Indirizzo:</strong> ${vehicle.indirizzo}
                           lorem30
                        </p>
                        <a href="veicolo.html?id=${vehicle.id}" class="btn btn-danger">Dettagli</a>
                    </div>
                </div>
            </div>`;
    });
});