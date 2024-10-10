document.querySelectorAll('.play-button').forEach(button => {
    button.addEventListener('click', function() {
        const trackId = this.getAttribute('data-id');

        // Получаем трек по ID
        getTrackById(trackId).then(trackData => {
            // Обновляем название трека и исполнителя
            document.getElementById('track-name').innerText = trackData.name;
            document.getElementById('track-artist').innerText = trackData.artist;

            // Показать проигрыватель
            document.getElementById('track-player').style.bottom = '0';
        });
    });
});

// Функция для получения трека по ID
function getTrackById(id) {
    return fetch(`/track/${id}`)
        .then(response => response.json())
        .then(trackData => trackData);
}

// Скрываем проигрыватель при клике на кнопку закрытия
document.getElementById('close-player').addEventListener('click', function() {
    document.getElementById('track-player').style.bottom = '-100%'; // Прячем проигрыватель
});
