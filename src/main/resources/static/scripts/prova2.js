// class Prenotazione {
//   constructor(utente_id, veicolo_id) {
//     this.utente_id = utente_id;
//     this.veicolo_id = veicolo_id;
//     this.dataInizio = new Date().toISOString();
  
//   }
//   async salva() {
//     const formData = new FormData();
//     formData.append("utente_id", this.utente_id);
//     formData.append("veicolo_id", this.veicolo_id);
//     formData.append("dataInizio", this.dataInizio);

//     try {
//       const response = await fetch(
//         "http://localhost:8080/api/prenotazioni",
//         {
//           method: "POST",
//           body: formData,
//         }
//       );

//       if (response.ok) {
//         const data = await response.json();
//         console.log("prenotazione effettuata con successo: ", data);
//       } else {
//         const error = await response.text();
//         console.log("errore durante la prenotazione", error);
//       }
//     } catch (error) {
//       console.error("errore nella richiesta", error);
//     }
//   }
// }



// async salva() {
//     const formData = new FormData();
//     formData.append("utente_id", this.utente_id);
//     formData.append("veicolo_id", this.veicolo_id);
  
//     try {
//       const response = await fetch("http://localhost:8080/api/prenotazioni", {
//         method: "POST",
//         body: formData,
//       });
  
//       if (response.ok) {
//         // Prova a leggere come JSON se la risposta è valida
//         const data = await response.json();
//         console.log("Prenotazione effettuata con successo: ", data);
//       } else {
//         // Controlla il tipo di contenuto della risposta
//         const contentType = response.headers.get("Content-Type");
//         if (contentType && contentType.includes("application/json")) {
//           const errorData = await response.json();
//           console.log("Errore durante la prenotazione", errorData);
//         } else {
//           const errorText = await response.text();
//           console.log("Errore durante la prenotazione", errorText);
//         }
//       }
//     } catch (error) {
//       console.error("Errore nella richiesta", error);
//     }
// }
// } 

class Prenotazione {
    constructor(utente_id, veicolo_id) {
      this.utente_id = utente_id;
      this.veicolo_id = veicolo_id;
      this.dataInizio = new Date().toISOString();
    }
  
    async salva() {
      const formData = new FormData();
      formData.append("utente_id", this.utente_id);
      formData.append("veicolo_id", this.veicolo_id);
  
      try {
        const response = await fetch("http://localhost:8080/api/prenotazioni", {
          method: "POST",
          body: formData,
        });
  
        if (response.ok) {
          const contentType = response.headers.get("Content-Type");
          if (contentType && contentType.includes("application/json")) {
            // Se il backend restituisce una risposta JSON valida
            const data = await response.json();
            console.log("Prenotazione effettuata con successo: ", data);
          } else {
            // Se non è un JSON valido ma l'operazione è completata
            console.log("Prenotazione effettuata con successo, ma la risposta non è JSON.");
          }
        } else {
          // Gestione degli errori di risposta
          const contentType = response.headers.get("Content-Type");
          if (contentType && contentType.includes("application/json")) {
            const errorData = await response.json();
            console.log("Errore durante la prenotazione: ", errorData);
          } else {
            const errorText = await response.text();
            console.log("Errore durante la prenotazione: ", errorText);
          }
        }
      } catch (error) {
        console.error("Errore nella richiesta: ", error);
      }
    }
  }
  
  document.getElementById("formPrenotazione").addEventListener("submit", function (event) {
    event.preventDefault();
    const utente_id = document.getElementById("utente_id").value;
    const veicolo_id = document.getElementById("veicolo_id").value;
  
    const prenotazione = new Prenotazione(utente_id, veicolo_id);
    prenotazione.salva();
  });
  