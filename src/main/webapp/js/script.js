function populateHistoryDropdowns() {
    const historyDropdowns = document.querySelectorAll('.history-dropdown');
    historyDropdowns.forEach((dropdown) => {
        // Clear existing options
        dropdown.innerHTML = '<option selected="selected" disabled="true">History</option>';

        const cookies = document.cookie.split(';');
        const historyCookies = [];

        for (const cookie of cookies) {
            const [cookieName, cookieValue] = cookie.trim().split('=');
            if (cookieName.startsWith("history")) {
                historyCookies.push(cookieValue);
            }
        }

        // Only keep the most recent 5 history items
        const recentHistory = historyCookies.slice(-5);

        for (const item of recentHistory) {
            dropdown.innerHTML += `<option value="${item}">${item}</option>`;
        }

        // Add an event listener to each dropdown
        dropdown.addEventListener('change', function () {
            const selectedOption = dropdown.options[dropdown.selectedIndex];
            const inputField = dropdown.previousElementSibling.querySelector('input[name="Val1"]');

            if (inputField) {
                inputField.value = selectedOption.value;
            }
        });
    });
}

window.addEventListener('load', populateHistoryDropdowns);

document.addEventListener('DOMContentLoaded', function () {
    const dropdowns = document.querySelectorAll('.history-dropdown');
    const textInputs = document.querySelectorAll('input[name^="Val"]'); // Assuming your text inputs have a name attribute starting with "Val"

    dropdowns.forEach(function (dropdown, index) {
        const textInput = textInputs[index];
        if (textInput) {
            dropdown.addEventListener('change', function () {
                textInput.value = this.value;
            });
        }
    });
});

