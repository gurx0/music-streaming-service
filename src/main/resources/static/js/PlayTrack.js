// Переменные для списка треков и текущего трека
let trackList = [];  // Массив для хранения треков
let currentTrackIndex = -1;  // Индекс текущего трека

// Проверяем, была ли переменная audioPlayer уже объявлена
if (typeof audioPlayer === 'undefined') {
    var audioPlayer = new Audio();  // Создаем объект Audio для воспроизведения треков
}

// Функция для воспроизведения трека по индексу
function playTrackByIndex(index) {
    const trackId = trackList[index];
    fetch(`/track/${trackId}`)
        .then(response => response.json())
        .then(trackData => {
            // Установка названия трека
            document.getElementById('track-name').innerText = trackData.name;

            // Установка названия артистов
            if (trackData.artist && trackData.artist.length > 0) {
                const artist_names = trackData.artist.map(artist => artist.name).join(', '); // Собираем имена всех артистов
                document.getElementById('track-artist').innerText = artist_names;
            } else {
                document.getElementById('track-artist').innerText = 'Неизвестный артист';
            }

            // Установка пути к аудиофайлу
            const audioSource = document.getElementById('audio-source');
            audioSource.src = `/${trackData.url}`;  // Устанавливаем ссылку на трек
            audioPlayer.src = `/${trackData.url}`;  // Загружаем трек в объект Audio
            audioPlayer.load();
            audioPlayer.play();

            // Показать плеер
            document.getElementById('track-player').style.bottom = '0';  // Показываем плеер
        })
        .catch(error => console.error('Error fetching track:', error));

    // При запуске трека увеличиваем количество прослушиваний
    fetch(`/track/${trackId}/increment-play-count`, {
        method: 'PUT'
    }).catch(error => console.error('Ошибка при увеличении счетчика прослушиваний:', error));
}

// Обработчик для кнопки воспроизведения трека
document.querySelectorAll('.play-button').forEach(button => {
    button.addEventListener('click', function() {
        const trackId = this.getAttribute('data-id');

        // Добавляем трек в список и воспроизводим
        trackList = Array.from(document.querySelectorAll('.play-button')).map(btn => btn.getAttribute('data-id'));
        currentTrackIndex = trackList.indexOf(trackId);  // Находим индекс текущего трека
        playTrackByIndex(currentTrackIndex);  // Воспроизводим текущий трек
    });
});

// Автовоспроизведение следующего трека
audioPlayer.addEventListener('ended', function() {
    if (currentTrackIndex < trackList.length - 1) {
        currentTrackIndex++;  // Увеличиваем индекс для следующего трека
        playTrackByIndex(currentTrackIndex);  // Воспроизводим следующий трек
    }
});

// Управление громкостью
document.getElementById('volume-control').addEventListener('input', function() {
    audioPlayer.volume = this.value / 100;  // Установка громкости от 0 до 1
});

// Управление паузой и воспроизведением
document.getElementById('play-pause-button').addEventListener('click', function() {
    if (audioPlayer.paused) {
        audioPlayer.play();
        this.innerText = '⏸️';  // Изменяем текст на кнопку
    } else {
        audioPlayer.pause();
        this.innerText = '▶️';  // Изменяем текст на кнопку
    }
});

// Перемотка трека
document.getElementById('track-progress').addEventListener('input', function() {
    audioPlayer.currentTime = (audioPlayer.duration * this.value) / 100;  // Установка текущего времени
});

// Обновление прогресса
audioPlayer.addEventListener('timeupdate', function() {
    const progressBar = document.getElementById('track-progress');
    progressBar.value = (audioPlayer.currentTime / audioPlayer.duration) * 100;  // Обновление ползунка прогресса
});

// Закрытие плеера
document.getElementById('close-player').addEventListener('click', function() {
    audioPlayer.pause();  // Остановка воспроизведения
    audioPlayer.currentTime = 0;  // Сброс текущего времени трека на 0
    document.getElementById('track-player').style.bottom = '-100%';  // Прячем плеер
});
