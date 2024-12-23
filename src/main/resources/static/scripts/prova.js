// class Veicolo {
//     constructor(veicolo_id, categoria, descrizione, alimentazione, indirizzo, coordinate, disponibilita, immagine) {
//         this.veicolo_id = veicolo_id;
//         this.categoria = categoria;
//         this.descrizione = descrizione;
//         this.alimentazione = alimentazione;
//         this.indirizzo = indirizzo;
//         this.coordinate = coordinate;
//         this.disponibilita = disponibilita;
//         this.immagine = immagine;
//     }

//     // submitVeicolo() {
//     //     const formData = new FormData();
//     //     // formData.append("veicolo_id", this.veicolo_id);
//     //     formData.append("categoria", this.categoria);
//     //     formData.append("descrizione", this.descrizione);
//     //     formData.append("alimentazione", this.alimentazione);
//     //     formData.append("indirizzo", this.indirizzo);
//     //     formData.append("coordinate", this.coordinate);
//     //     formData.append("disponibilita", this.disponibilita);
//     //     formData.append("image", this.immagine);

//     //     fetch('/api/veicoli', {
//     //         method: 'POST',
//     //         body: formData
//     //     })


//     //     // .then(response => response.json())

//     //     .then(response => {
//     //         if (!response.ok) {
//     //             throw new Error('Errore durante la richiesta');
//     //         }
//     //         return response.json();
//     //     })


//     //     // .then(data => {
//     //     //     alert('Veicolo aggiunto con successo!');
//     //     //     document.getElementById("vehicleForm").reset();
//     //     // })
//     //     .then(data => {
//     //         console.log("Veicolo aggiunto:", data);
//     //         alert('Veicolo aggiunto con successo! ID: ' + data.veicolo_id);
//     //         // document.getElementById("veicoloId").textContent = data.veicolo_id;
//     //         // document.getElementById("result").style.display = 'block';
//     //         document.getElementById("vehicleForm").reset();
//     //     })
//     //     .catch(error => {
//     //         console.error('Errore:', error);
//     //         alert("Si è verificato un errore durante l'aggiunta del veicolo");
//     //     });
//     // }
    

//     async submitVeicolo() {
//         const formData = new FormData();
//         formData.append("categoria", this.categoria);
//         formData.append("descrizione", this.descrizione);
//         formData.append("alimentazione", this.alimentazione);
//         formData.append("indirizzo", this.indirizzo);
//         formData.append("coordinate", this.coordinate);
//         formData.append("disponibilita", this.disponibilita);
//         formData.append("image", this.immagine);
        

//         try {
//             let response = await fetch('/api/veicoli', {
//                 method: 'POST',
//                 body: formData
                
//             });

//             if (!response.ok) {
//                 throw new Error('Errore durante la richiesta');
//             }

//             let data;

//             try {
//             data = await response.json();
//             console.log("Veicolo aggiunto:", data);
//             alert('Veicolo aggiunto con successo! ID: ' + data.veicolo_id);
//             } catch (e) {
//                 throw new Error('Impossibile leggere la risposta JSON');
//             } finally {
//                 document.getElementById("vehicleForm").reset();
//             }

//         } catch (error) {
//             console.error('Errore:', error);
//             alert("Si è verificato un errore durante l'aggiunta del veicolo");
//         }
//     }
// }





// // document.getElementById("vehicleForm").addEventListener("submit", function(event) {
// //     event.preventDefault();

// //     const categoria = document.getElementById("categoria").value;
// //     const descrizione = document.getElementById("descrizione").value;
// //     const alimentazione = document.getElementById("alimentazione").value;
// //     const indirizzo = document.getElementById("indirizzo").value;
// //     const coordinate = document.getElementById("coordinate").value;
// //     const disponibilita = document.getElementById("disponibilita").value;
// //     const immagine = document.getElementById("image").files[0];

// //     const veicolo = new Veicolo(categoria, descrizione, alimentazione, indirizzo, coordinate, disponibilita, immagine);
// //     veicolo.submitVeicolo(); 
// // });

// document.getElementById("vehicleForm").addEventListener("submit", async function(event) {
//     event.preventDefault();

//     const id = null;
//     const categoria = document.getElementById("categoria").value;
//     const descrizione = document.getElementById("descrizione").value;
//     const alimentazione = document.getElementById("alimentazione").value;
//     const indirizzo = document.getElementById("indirizzo").value;
//     const coordinate = document.getElementById("coordinate").value;
//     let disponibilita = document.getElementById("disponibilita").value;
//     const immagine = document.getElementById("image").files[0];

//     if (disponibilita === 'disponibile') {
//         disponibilita = true;
//     } else {
//         disponibilita = false;
//     }

//     const veicolo = new Veicolo(id, categoria, descrizione, alimentazione, indirizzo, coordinate, disponibilita, immagine);
//     console.log(veicolo);
//     console.log(disponibilita);
    
    
    
//     await veicolo.submitVeicolo(); 
// });

// const getVeicoli = async () => {
//     const response = await fetch('http://localhost:8080/api/veicoli');
//     const data = await response.json();

//     console.log(data);
//     return data;
// } 

// const bottoneGET = document.querySelector('.bottoneGet')

// bottoneGET.addEventListener("click", async function(event) {
//     event.preventDefault();
//     await getVeicoli();
    
// })


class Veicolo {
    constructor(veicolo_id, categoria, descrizione, alimentazione, indirizzo, coordinate, disponibilita, immagine) {
        this.veicolo_id = veicolo_id;
        this.categoria = categoria;
        this.descrizione = descrizione;
        this.alimentazione = alimentazione;
        this.indirizzo = indirizzo;
        this.coordinate = coordinate;
        this.disponibilita = disponibilita;
        this.immagine = immagine;
    }

    async submitVeicolo() {
        const formData = new FormData();
        formData.append("categoria", this.categoria);
        formData.append("descrizione", this.descrizione);
        formData.append("alimentazione", this.alimentazione);
        formData.append("indirizzo", this.indirizzo);
        formData.append("coordinate", this.coordinate);
        formData.append("disponibilita", this.disponibilita);
        
        // Aggiungi l'immagine solo se è stata selezionata
        if (this.immagine) {
            formData.append("image", this.immagine);
        }

        try {
            let response = await fetch('http://localhost:8080/api/veicoli', {
                method: 'POST',
                body: formData
            });

            if (!response.ok) {
                throw new Error('Errore durante la richiesta');
            }

            let data = await response.json();
            console.log("Veicolo aggiunto:", data);
            alert('Veicolo aggiunto con successo! ID: ' + data.veicolo_id);
            document.getElementById("vehicleForm").reset(); // Reset del form

        } catch (error) {
            console.error('Errore:', error);
            alert("Si è verificato un errore durante l'aggiunta del veicolo");
        }
    }
}

document.getElementById("vehicleForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const id = null; // ID non fornito per un nuovo veicolo
    const categoria = document.getElementById("categoria").value;
    const descrizione = document.getElementById("descrizione").value;
    const alimentazione = document.getElementById("alimentazione").value;
    const indirizzo = document.getElementById("indirizzo").value;
    const coordinate = document.getElementById("coordinate").value;
    
    let disponibilita = document.getElementById("disponibilita").value;
    const immagine = document.getElementById("image").files[0]; // Ottieni il file immagine selezionato

    // Converti disponibilita in booleano
    disponibilita = disponibilita === 'disponibile' ? true : false;

    const veicolo = new Veicolo(id, categoria, descrizione, alimentazione, indirizzo, coordinate, disponibilita, immagine);
    console.log(veicolo); // Per debugging

    // Invia i dati tramite il metodo submitVeicolo
    await veicolo.submitVeicolo(); 
});

const getVeicoli = async () => {
    const response = await fetch('http://localhost:8080/api/veicoli');
    const data = await response.json();
    console.log(data);
    return data;
}

const bottoneGET = document.querySelector('.bottoneGet');

bottoneGET.addEventListener("click", async function(event) {
    event.preventDefault();
    await getVeicoli();
});
