docker run --name luncheon-supertokens \
	-p 3567:3567 \
	-e POSTGRESQL_CONNECTION_URI="postgresql://supertokens:supertokens@host.docker.internal:5432/supertokens?schema=public" \
  -e API_KEYS="Dh5RBOvnoqzGXcVEZe8OeyXcyR91JrYg0IRNQJ9mKqKC7nrCdynQ2FxNiGY8eQa5nfmPpHI3H2ZHwmZhRv2pi5YtbLtaoJtIvnl1Nmc0YnCpz8BVRnQZMcZCeCm0Wt1w" \
  -e PASSWORD_HASHING_ALG=BCRYPT \
  -e BCRYPT_LOG_ROUNDS=11 \
  -e ACCESS_TOKEN_BLACKLISTING=true \
  -e REFRESH_TOKEN_VALIDITY=43200 \
  -e ACCESS_TOKEN_VALIDITY=3600 \
	-d registry.supertokens.io/supertokens/supertokens-postgresql