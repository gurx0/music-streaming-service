document.querySelectorAll('.play-button').forEach(button => {
    button.addEventListener('click', function() {
        const trackId = this.getAttribute('data-id');

        const trackData = getTrackById(trackId);

        document.getElementById('track-name').innerText = trackData.name;
        document.getElementById('track-artist').innerText = trackData.musician;

        // Show the track player
        document.getElementById('track-player').style.bottom = '0';
    });
});

document.getElementById('close-player').addEventListener('click', function() {
    document.getElementById('track-player').style.bottom = '-100%';
});

function getTrackById(id) {
    // Здесь должна быть логика получения трека по id, пока что это заглушка
    const tracks = [
        {id: 1, name: 'Трек 1', musician: 'Исполнитель 1'},
        {id: 2, name: 'Трек 2', musician: 'Исполнитель 2'}
    ];

    return tracks.find(track => track.id == id);
}
