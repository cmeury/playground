class WrongNumberOfPlayersError < StandardError ; end
class NoSuchStrategyError < StandardError ; end

def rps_game_winner(game)
	raise WrongNumberOfPlayersError if game.length != 2
	game.each do |move|
		raise NoSuchStrategyError unless move[1] == "R" || move[1] == "P" || move[1] == "S"
	end 
  
  one = game[0][1]
  two = game[1][1]
  if one == two
		return game[0]   # return first player upon tie
  elsif game[0][1] == "R"
		if game[1][1] == "P"
			return game[1]
		else # "S"
			return game[0]
		end
	elsif game[0][1] == "S"
		if game[1][1] == "R"
			return game[1]
		else # "P"
			return game[0]
		end
	else # "R"
		if game[1][1] == "S"
			return game[1]
		else
			return game[0]
		end
	end
end

def rps_tournament_winner(tournament)
	if tournament[0][0].is_a? String
		return rps_game_winner(tournament)
	end
	return rps_tournament_winner( [ rps_tournament_winner(tournament[0]), rps_tournament_winner(tournament[1]) ] )
end

t = [
    [
        [ ["Armando", "P"], ["Dave", "S"] ],
        [ ["Richard", "R"],  ["Michael", "S"] ],
    ],
    [
        [ ["Allen", "S"], ["Omer", "P"] ],
        [ ["David E.", "R"], ["Richard X.", "P"] ]
    ]
]

#puts rps_tournament_winner t
