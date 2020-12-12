class Typing {
    constructor(text) {
        this.text = text;
        this.index = 0;
        this.spans = [];
    }

    start() {
        const displayInput = document.getElementById('display-input');

        for (let i = 0; i < this.text.length; i++) {
            const letter = this.text[i];

            const span = document.createElement('span');
            span.className = "letter";
            span.innerText = letter;

            displayInput.appendChild(span);
            this.spans[i] = span;
        }
        displayInput.childNodes[0].className = "letter current-letter";


// add event input user
        window.addEventListener("keypress", (e) => {

            const span = this.spans[this.index];
            const letter = this.text[this.index];
            if (letter === e.key) {
                if (this.index === this.text.length - 1) {
                    // WIN GAME
                    console.log('win');
                    sendTypingToServer(letter);
                    span.className = "letter";
                    return;
                }
                // TYPING CORRECT
                sendTypingToServer(letter);
                span.className = "letter";
                this.spans[this.index + 1].className = "letter current-letter";
                this.index++;
            }
        });
    }
}


function sendTypingToServer(letter) {
    const msg = JSON.stringify({
        head: "typing",
        body: {
            roomId: roomId,
            letter: letter
        }
    })
    socket.send(msg);
}
