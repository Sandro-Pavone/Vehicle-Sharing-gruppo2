class Veicolo {
  constructor(
    veicolo_id,
    categoria,
    descrizione,
    alimentazione,
    indirizzo,
    coordinate,
    disponibilita,
    immagine
  ) {
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

    if (this.immagine) {
      formData.append("image", this.immagine);
    }

    try {
      let response = await fetch("http://localhost:8080/api/veicoli", {
        method: "POST",
        body: formData,
      });

      if (!response.ok) {
        throw new Error("Errore durante la richiesta");
      }

      let data = await response.json();
      console.log("Veicolo aggiunto:", data);
      alert("Veicolo aggiunto con successo! ID: " + data.veicolo_id);
      document.getElementById("vehicleForm").reset();
    } catch (error) {
      console.error("Errore:", error);
      alert("Si è verificato un errore durante l'aggiunta del veicolo");
    }
  }
}

document
  .getElementById("vehicleForm")
  .addEventListener("submit", async function (event) {
    event.preventDefault();

    const id = null;
    const categoria = document.getElementById("categoria").value;
    const descrizione = document.getElementById("descrizione").value;
    const alimentazione = document.getElementById("alimentazione").value;
    const indirizzo = document.getElementById("indirizzo").value;
    const coordinate = document.getElementById("coordinate").value;

    let disponibilita = document.getElementById("disponibilita").value;
    const immagine = document.getElementById("image").files[0];

    disponibilita = disponibilita === "disponibile" ? true : false;

    const veicolo = new Veicolo(
      id,
      categoria,
      descrizione,
      alimentazione,
      indirizzo,
      coordinate,
      disponibilita,
      immagine
    );
    console.log(veicolo);

    await veicolo.submitVeicolo();
  });

const getVeicoli = async () => {
  const response = await fetch("http://localhost:8080/api/veicoli");
  const data = await response.json();
  console.log(data);
  return data;
};

const bottoneGET = document.querySelector(".bottoneGet");

bottoneGET.addEventListener("click", async function (event) {
  event.preventDefault();
  await getVeicoli();
});
