module Business.MatchHandler where

import Business.Utils.SuportFunctions
import Domain.Match
import Domain.TeamResults

import Infra.Repositories.MatchRepository

--Retorna as vitórias, espates e derrotas de um determinado time // requisito 1
getMatchesResultsByTeamInChampionship :: String -> IO (Int, Int, Int)
getMatchesResultsByTeamInChampionship teamName = do
    matches <- getMatches

    let teamResults = getTeamResultsByTeam teamName matches

    return (victories teamResults, draws teamResults, loss teamResults)

--Retorna o aproveitamento de um determinado time no campeonato // requisito 3
getEnjoymentByTeamInChampionship :: String -> IO Float
getEnjoymentByTeamInChampionship teamName = do
    results <- getMatchesResultsByTeamInChampionship teamName

    let enjoyment = getTotalEnjoyment results

    return enjoyment

--Retorna o saldo de gols de um determinado time // requisito 4
getGoalBalanceByTeamInChampionship :: String -> IO Int
getGoalBalanceByTeamInChampionship teamName = do
    matches <- getMatches

    let teamResults = getTeamResultsByTeam teamName matches

    return (goals teamResults)


--Retorna os resultados das partidas de uma determinada rodada 
-- e de um determinado time // requisito 5
getMatchesResultsByRoundAndByTeamInChampionship :: Int -> String -> IO [Match]
getMatchesResultsByRoundAndByTeamInChampionship round teamName = do
    matches <- getMatches

    let teamMatches = filterMatchesByTeam teamName matches

    let teamMatchesByRound = filterMatchesByRound round teamMatches

    return teamMatchesByRound
