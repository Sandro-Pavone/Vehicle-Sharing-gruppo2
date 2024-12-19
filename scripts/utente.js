document.addEventListener("DOMContentLoaded", () => {
    // Simulazione dell'autenticazione dell'utente (ad esempio, ID utente)
    const user = {
        id: 1,
        nome: "Giovanni Rossi",
        prenotazioni: [
            {
                id: 1,
                veicolo: "Fiat Panda",
                categoria: "Auto",
                dataInizio: "2024-12-20",
                dataFine: "2024-12-22",
                stato: "Confermato"
            },
            {
                id: 2,
                veicolo: "Mountain Bike Elettrica",
                categoria: "Bicicletta",
                dataInizio: "2024-12-18",
                dataFine: "2024-12-19",
                stato: "Confermato"
            }
        ]
    };

    // Funzione per creare l'elenco delle prenotazioni
    const bookingListContainer = document.getElementById("booking-list");

    user.prenotazioni.forEach(prenotazione => {
        const bookingCard = document.createElement("div");
        bookingCard.classList.add("card", "my-3");

        bookingCard.innerHTML = `
            <div class="card-body">
                <h5 class="card-title">${prenotazione.veicolo} (${prenotazione.categoria})</h5>
                <p class="card-text">
                    Periodo: ${prenotazione.dataInizio} - ${prenotazione.dataFine}<br>
                    Stato: <span class="badge ${prenotazione.stato === "Confermato" ? "bg-success" : "bg-warning"}">${prenotazione.stato}</span>
                </p>
                <button class="btn btn-warning" onclick="editBooking(${prenotazione.id})">Modifica</button>
                <button class="btn btn-danger" onclick="deleteBooking(${prenotazione.id})">Cancella</button>
            </div>
        `;

        bookingListContainer.appendChild(bookingCard);
    });

    // Funzione per gestire la modifica della prenotazione (simulata)
    window.editBooking = (bookingId) => {
        alert(`Modifica prenotazione con ID: ${bookingId}`);
        // Qui puoi implementare il comportamento per modificare la prenotazione
    };

    // Funzione per gestire la cancellazione della prenotazione
    window.deleteBooking = (bookingId) => {
        const modal = new bootstrap.Modal(document.getElementById('confirm-delete-modal'));
        const confirmDeleteButton = document.getElementById('confirm-delete');

        confirmDeleteButton.onclick = () => {
            // Qui simuleremo la cancellazione
            alert(`Prenotazione con ID: ${bookingId} cancellata!`);
            // Rimuovi la prenotazione dalla lista
            const bookingCard = document.querySelector(`#booking-list .card-body`);
            bookingCard.remove();
            modal.hide();
        };

        modal.show();
    };
});