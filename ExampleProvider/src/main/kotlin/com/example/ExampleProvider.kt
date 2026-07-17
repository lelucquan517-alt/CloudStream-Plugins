package com.example

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.ExtractorLink

class ExampleProvider : MainAPI() {
    override var mainUrl = "https://example.com"
    override var name = "Example Provider"
    override val supportedTypes = setOf(TvType.Movie, TvType.TvSeries)

    override suspend fun search(query: String): List<SearchResponse> {
        // Sử dụng hàm tạo mới chuẩn xác cho MovieSearchResponse
        return listOf(
            newMovieSearchResponse("Example Movie", "$mainUrl/movie", TvType.Movie) {
                this.posterUrl = "https://example.com/poster.jpg"
            }
        )
    }

    override suspend fun load(url: String): LoadResponse {
        return newMovieLoadResponse("Example Movie", url, TvType.Movie, url) {
            this.posterUrl = "https://example.com/poster.jpg"
            this.plot = "This is an example movie description"
        }
    }

    override suspend fun loadLinks(
        data: String,
        isCaster: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {
        return true
    }
}
