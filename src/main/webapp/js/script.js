/*
  the usage of the javascript mainly aims to enhance the front-end side of the application.
    there are two features that are implemented by the scripts:
        - populate the two history dropdowns (reduces the redundancy in the jsp)
        - transpose or copy-paste the values from the selected option in the history
            dropdown to the textfield.

    note: upon analysis, the first feature does seem to overlap with the cookies,
        but nevertheless, it doesn't override or outdo the intended function, logic,
        or algorithm set place for the cookies in the servlet. 

        the second feature has mitigated the potential problem caused by error 422.
        though, as it only serves as copy-paste, the liberty is still within the 
        user to edit or use the inputted value in the textfields.

        additionally, the script use provides dynamic and immediate refresh
        of the dropdown results, whereas, previously, the user needs to refresh
        the page or commit another calculation for the previous calculation.
 */

function populateHistoryDropdowns() {
    const historyDropdowns = document.querySelectorAll('.history-dropdown');
    historyDropdowns.forEach((dropdown) => {
        // clears the existing options
        dropdown.innerHTML = '<option selected="selected" disabled="true">History</option>';

        const cookies = document.cookie.split(';');
        const historyCookies = [];

        for (const cookie of cookies) {
            const [cookieName, cookieValue] = cookie.trim().split('=');
            if (cookieName.startsWith("history")) {
                historyCookies.push(cookieValue);
            }
        }

        // keeps the most recent 5 history items, bridges the servlet and the jsp (sort of)
        const recentHistory = historyCookies.slice(-5);

        for (const item of recentHistory) {
            dropdown.innerHTML += `<option value="${item}">${item}</option>`;
        }

    });
}

document.addEventListener('DOMContentLoaded', function () {
        // event listener to each dropdown, tranposes the selected data to the text field
    const dropdowns = document.querySelectorAll('.history-dropdown');
    const textInputs = document.querySelectorAll('input[name^="Val"]');

    dropdowns.forEach(function (dropdown, index) {
        const textInput = textInputs[index];
        if (textInput) {
            dropdown.addEventListener('change', function () {
                textInput.value = this.value;
            });
        }
    });
});

window.addEventListener('load', populateHistoryDropdowns);