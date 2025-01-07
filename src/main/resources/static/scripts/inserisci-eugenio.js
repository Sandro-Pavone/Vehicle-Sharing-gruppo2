/* SERVE CONTROLLO TOKEN D'ACCESSO*/

document.addEventListener("DOMContentLoaded", () => {
    const vehicleForm = document.getElementById("vehicleForm");
    const logoutButton = document.getElementById("logout");

    // Gestione Logout
    logoutButton.addEventListener("click", () => {
        window.location.href = "index.html"; // Reindirizza alla home
    });

    // Gestione Form
    vehicleForm.addEventListener("submit", async (event) => {
        event.preventDefault(); // Previene il comportamento predefinito

        // Raccogli i dati dal form
        const categoria = document.getElementById("categoria").value;
        const descrizione = document.getElementById("descrizione").value;
        const alimentazione = document.getElementById("alimentazione").value;
        const indirizzo = document.getElementById("indirizzo").value || null;
        const gps = document.getElementById("gps").value || null;
        const disponibile = document.getElementById("disponibile").checked;
        const immagine = document.getElementById("immagine").files[0] || null;

        // Preparazione del payload
        const formData = new FormData();
        formData.append("categoria", categoria);
        formData.append("descrizione", descrizione);
        formData.append("alimentazione", alimentazione);
        formData.append("indirizzo", indirizzo);
        formData.append("gps", gps);
        formData.append("disponibile", disponibile);
        if (immagine) {
            formData.append("immagine", immagine);
        }

        // Chiamata API
        try {
            const response = await fetch("http://localhost:8080/api/vehicles/add", {
                method: "POST",
                body: JSON.stringify({
                    categoria,
                    descrizione,
                    alimentazione,
                    indirizzo,
                    gps,
                    disponibile
                }),
                headers: {
                    "Content-Type": "application/json"
                }
            });

            if (!response.ok) {
                throw new Error("Errore durante l'inserimento del veicolo");
            }

            alert("Veicolo inserito con successo!");
            vehicleForm.reset(); // Resetta il form
        } catch (error) {
            console.error(error);
            alert("Errore durante l'inserimento del veicolo.");
        }
    });
});
