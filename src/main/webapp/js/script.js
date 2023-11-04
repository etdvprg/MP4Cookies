function populateHistoryDropdowns() {
    const historyDropdowns = document.querySelectorAll('.history-dropdown');

    historyDropdowns.forEach((dropdown) => {
        const cookies = document.cookie.split(';');
        let historyOptions = '';

        for (let i = 0; i < 5; i++) {
            const cookie = cookies[i].trim();
            if (cookie.startsWith("history")) {
                historyOptions += `<option value="${cookie.split('=')[1]}">${cookie.split('=')[1]}</option>`;
            }
        }

        dropdown.innerHTML += historyOptions;
    });
}

window.addEventListener('load', populateHistoryDropdowns);