package abc.def.futurethings

data class CoolResponse(
    val result: List<Result>,
    val status: String
)

data class Result(
    val avatar: String,
    val city: String,
    val contribution: Int,
    val country: String,
    val email: String,
    val firstName: String,
    val friendOfCount: Int,
    val handle: String,
    val lastName: String,
    val lastOnlineTimeSeconds: Int,
    val maxRank: String,
    val maxRating: Int,
    val organization: String,
    val rank: String,
    val rating: Int,
    val registrationTimeSeconds: Int,
    val titlePhoto: String
)