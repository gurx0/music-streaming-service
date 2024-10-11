document.querySelectorAll('.play-button').forEach(button => {
    button.addEventListener('click', function() {
        const trackId = this.getAttribute('data-id');

        // Запрос к серверу для получения данных о треке по ID
        fetch(`/track/${trackId}`)
            .then(response => response.json())
            .then(trackData => {
                // Установка названия трека и исполнителя
                document.getElementById('track-name').innerText = trackData.name;
                document.getElementById('track-artist').innerText = trackData.artist;

                // Установка пути к аудиофайлу
                const audioPlayer = document.getElementById('audio-player');
                const audioSource = document.getElementById('audio-source');
                audioSource.src = `/audio/${trackData.url}`; // Здесь добавляется только имя файла
                audioPlayer.load();  // Загружаем новый трек в плеер

                // Показать плеер
                document.getElementById('track-player').style.bottom = '0'; // Показать плеер
            })
            .catch(error => console.error('Error fetching track:', error));
    });
});

// Управление громкостью
document.getElementById('volume-control').addEventListener('input', function() {
    const audioPlayer = document.getElementById('audio-player');
    audioPlayer.volume = this.value / 100; // Установка громкости от 0 до 1
});

// Управление паузой и воспроизведением
document.getElementById('play-pause-button').addEventListener('click', function() {
    const audioPlayer = document.getElementById('audio-player');
    if (audioPlayer.paused) {
        audioPlayer.play();
        this.innerText = '⏸️'; // Изменяем текст на кнопку
    } else {
        audioPlayer.pause();
        this.innerText = '▶️'; // Изменяем текст на кнопку
    }
});

// Перемотка трека
document.getElementById('track-progress').addEventListener('input', function() {
    const audioPlayer = document.getElementById('audio-player');
    audioPlayer.currentTime = (audioPlayer.duration * this.value) / 100; // Установка текущего времени
});

// Обновление прогресса
const audioPlayer = document.getElementById('audio-player');
audioPlayer.addEventListener('timeupdate', function() {
    const progressBar = document.getElementById('track-progress');
    progressBar.value = (audioPlayer.currentTime / audioPlayer.duration) * 100; // Обновление ползунка прогресса
});

// Закрытие плеера
document.getElementById('close-player').addEventListener('click', function() {
    document.getElementById('track-player').style.bottom = '-100%';  // Прячем плеер
});

