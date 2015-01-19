YOUR_CLIENT_ID = "9e87eb4f602e43f2a5b38c462e4c80ff"
YOUR_CLIENT_SECRET = "285beb9fe89b41dc801b983e23137792"

from instagram.client import InstagramAPI
api = InstagramAPI(client_id=YOUR_CLIENT_ID, client_secret=YOUR_CLIENT_SECRET)

# popular_media = api.media_popular(count=20)
# for media in popular_media:
#     print media.images['standard_resolution'].url

zovi_media = api.tag_recent_media(count=2,tag_name="zovi")
print zovi_media[0]
for media in zovi_media[0]:
	print media.user,media.type

	print media.images['low_resolution'].height,media.images['low_resolution'].width
