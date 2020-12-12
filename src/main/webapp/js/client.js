const socket = new WebSocket("ws://localhost:8080/RacingGame_war/race")
const players = document.getElementById('players');
socket.onopen = ev => {

}
socket.onmessage = ev => {
    try {

        const data = JSON.parse(ev.data);
        const head = data.head;
        const body = data.body;
        switch (head) {

            case "profile":
                const roomId = body.roomId;
                window.roomId = roomId;
                break;

            case "players":

                for (let i = 0; i < body.length; i++) {
                    const nameValue = body[i].name;
                    const percentageValue = body[i].percentage;
                    const speedValue = body[i].speed;
                    ////////// GET VALUE /////////
                    /////////////////////////////
                    // get value
                    let node = players.children[i];

                    // get name
                    let name = node.querySelector('strong.name-player');
                    // get progress
                    let progress = node.querySelector('div.progress-bar');
                    // get speed
                    let speed = node.querySelector('strong.speed-value');
                    
                    ////////// SET VALUE //////////
                    //////////////////////////////
                    // set name
                    name.innerText = nameValue;
                    // set progress bar
                    progress.style.width = percentageValue + "%";
                    // set speeed
                    speed.innerText = speedValue;
                    // display node
                    node.className = "";
                }
                break;
            case "running":
                document.getElementById('please-wait').remove();
                document.getElementById('typing').className = 'container';
                new Typing(body).start();
                break;

            case "complete":
                // display container complete
                const tmp = players;
                players.remove();
                const containerComplete = document.getElementById('container-complete');
                // remove class d-none
                containerComplete.className = '';
                // add players to main
                containerComplete.querySelector('main').appendChild(tmp);

                // hide container typing
                document.getElementById('container-typing').className = 'd-none';
                break;
        }
    } catch (e) {
        console.log(ev.data);
        console.log("data error");
    }

}

socket.onclose = ev => {

}

socket.onerror = ev => {

}